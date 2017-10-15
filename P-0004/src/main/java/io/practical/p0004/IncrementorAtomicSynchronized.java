package io.practical.p0004;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementorAtomicSynchronized {

	AtomicInteger count = new AtomicInteger(0);

	public IncrementorAtomicSynchronized() {
	}

	public void inc() {
		count.incrementAndGet();
	}

	public int getValue() {
		return count.get();
	}

}
