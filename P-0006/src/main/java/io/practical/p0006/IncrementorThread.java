package io.practical.p0006;

import java.util.concurrent.CountDownLatch;

public class IncrementorThread implements Runnable {

	private Counter counter;
	private CountDownLatch latch;

	public IncrementorThread(Counter counter, CountDownLatch latch) {
		this.counter = counter;
		this.latch = latch;
	}

	@Override
	public void run() {
		counter.increment();
		latch.countDown();
	}
}
