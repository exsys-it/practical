package io.practical.p0004;

public class ThreadIncrementorNotSynchronized implements Runnable {

	private IncrementorNotSynchronized counter;

	public ThreadIncrementorNotSynchronized(IncrementorNotSynchronized counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.inc();
	}
	
}
