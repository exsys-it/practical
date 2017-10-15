package io.practical.p0004;

public class IncrementorMethodSynchronized {

	Integer count = 0;

	public IncrementorMethodSynchronized() {
	}

	public synchronized void inc() {
		count++;
	}

	public int getValue() {
		return count;
	}

}
