package io.practical.p0004.incrementor;

import java.util.concurrent.atomic.AtomicLong;

public class IncrementorAtomicSynchronized implements Incrementor {

	AtomicLong count = new AtomicLong(0);

	public IncrementorAtomicSynchronized() {
	}

	public void inc() {
		count.incrementAndGet();
	}

	public long getValue() {
		return count.get();
	}

}
