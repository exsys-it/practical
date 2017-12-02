package io.practical.p0004.thread;

import java.util.concurrent.CountDownLatch;

import io.practical.p0004.incrementor.Incrementor;

public class ThreadIncrementor implements Runnable {

	private Incrementor counter;
	private CountDownLatch latch;

	public ThreadIncrementor(Incrementor counter, CountDownLatch latch) {
		this.counter = counter;
		this.latch = latch;
	}

	@Override
	public void run() {
		counter.inc();
		latch.countDown();
	}
}
