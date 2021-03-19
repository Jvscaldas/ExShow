package controller;

import java.util.concurrent.Semaphore;

public class Show extends Thread {

	private int idPessoa;
	private int ingresso;
	private static int compra;
	private Semaphore semaforo;

	public Show(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		login();
		Compra();
		try {
			semaforo.acquire();
			validacaoCompra();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void login() {
		int tempo = 1000;
		int processo = (int) ((Math.random() * 501) + 1000);
		if (processo <= 1000) {
			Compra();
		} else {
			System.out.println("Timeout");
		}
	}

	private void Compra() {
		int tempo = 2500;
		int processo = (int) ((Math.random() * 1000) + 2000);
		if (processo <= 2500) {
			validacaoCompra();
		} else {
			System.out.println("Final de tempo de sessão.");
		}
	}

	private void validacaoCompra() {
		int ingresso = 100;
		int compra = 0;
		if (ingresso > 0) {
			compra = (int) ((Math.random() * 4 - 0) + 0);
			System.out.println(compra + " ingressos comprados");
			ingresso = ingresso - compra;
		}
		if (ingresso == 0) {

			System.out.println("Esgotado!");
		}
	}
}
