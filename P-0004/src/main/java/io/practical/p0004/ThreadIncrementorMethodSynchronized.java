package io.practical.p0004;

public class ThreadIncrementorMethodSynchronized implements Runnable {

	private IncrementorMethodSynchronized counter;

	public ThreadIncrementorMethodSynchronized(IncrementorMethodSynchronized counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.inc();
	}

}
