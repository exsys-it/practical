package io.practical.p0004.incrementor;

public class IncrementorMethodSynchronized implements Incrementor {

	Long count = 0L;

	public IncrementorMethodSynchronized() {
	}

	public synchronized void inc() {
		count++;
	}

	public long getValue() {
		return count;
	}

}
