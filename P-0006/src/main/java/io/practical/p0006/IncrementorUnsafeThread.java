package io.practical.p0006;

import java.util.concurrent.CountDownLatch;

import sun.misc.Unsafe;

public class IncrementorUnsafeThread implements Runnable {

	private CounterUnsafe counter;
	private CountDownLatch latch;

	public IncrementorUnsafeThread(CounterUnsafe counter, CountDownLatch latch) {
		this.counter = counter;
		this.latch = latch;
	}

	@Override
	public void run() {
		counter.increment();
		latch.countDown();
	}
}
