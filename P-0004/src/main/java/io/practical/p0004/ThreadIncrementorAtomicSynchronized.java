package io.practical.p0004;

public class ThreadIncrementorAtomicSynchronized implements Runnable {

	private IncrementorAtomicSynchronized counter;

	public ThreadIncrementorAtomicSynchronized(IncrementorAtomicSynchronized counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.inc();
	}

}
