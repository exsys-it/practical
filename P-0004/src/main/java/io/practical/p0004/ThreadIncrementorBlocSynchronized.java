package io.practical.p0004;

public class ThreadIncrementorBlocSynchronized implements Runnable {

	private IncrementorBlocSynchronized counter;

	public ThreadIncrementorBlocSynchronized(IncrementorBlocSynchronized counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.inc();
	}

}
