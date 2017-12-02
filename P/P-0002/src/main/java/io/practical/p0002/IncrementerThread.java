package io.practical.p0002;

import java.util.concurrent.CountDownLatch;

public class IncrementerThread implements Runnable {

	private static int COUNT = 10_000;

	int id;
	CountDownLatch latch;

	public IncrementerThread(int id, CountDownLatch latch) {
		this.id = id;
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Thread #" + id + " start");
		for (int i = 0; i < COUNT; i++) {
		}
		System.out.println("Thread #" + id + " end -count: " + COUNT);
		latch.countDown();
	}
}
