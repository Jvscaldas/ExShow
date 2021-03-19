package view;

import java.util.concurrent.Semaphore;

import controller.Show;

public class MainShow {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);

		for (int i = 0; i < 300; i++) {
			Thread t = new Show(i, semaforo);
			t.start();
		}
	}

}