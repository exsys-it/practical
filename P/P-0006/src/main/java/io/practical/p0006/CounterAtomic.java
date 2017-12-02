package io.practical.p0006;

import java.util.concurrent.atomic.AtomicLong;

public class CounterAtomic {

	AtomicLong count = new AtomicLong(0);

	public CounterAtomic() {
	}

	public void increment() {
		count.incrementAndGet();
	}

	public long getValue() {
		return count.get();
	}

}
