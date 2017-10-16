package io.practical.p0004;

public class ThreadIncrementor implements Runnable {

	private Incrementor counter;

	public ThreadIncrementor(Incrementor counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		counter.inc();
	}
}
