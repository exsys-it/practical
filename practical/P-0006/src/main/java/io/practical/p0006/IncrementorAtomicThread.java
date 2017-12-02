package io.practical.p0006;

import java.util.concurrent.CountDownLatch;

public class IncrementorAtomicThread implements Runnable {

	private CounterAtomic counter;
	private CountDownLatch latch;

	public IncrementorAtomicThread(CounterAtomic counter, CountDownLatch latch) {
		this.counter = counter;
		this.latch = latch;
	}

	@Override
	public void run() {
		counter.increment();
		latch.countDown();
	}
}
