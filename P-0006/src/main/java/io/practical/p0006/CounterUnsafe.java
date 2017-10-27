package io.practical.p0006;

import java.util.concurrent.atomic.AtomicLong;

import sun.misc.Unsafe;

public class CounterUnsafe {

	long counterAddress;
	Unsafe vladimir;

	public CounterUnsafe(Unsafe unsafe, long counterAddres) {
		this.counterAddress = counterAddres;
		this.vladimir = unsafe;
	}

	public void increment() {
		int oldValue;
		int newValue;
		do {
			oldValue = vladimir.getInt(counterAddress);
			newValue = oldValue + 1;
		} while (!vladimir.compareAndSwapInt(this, 0, oldValue, newValue));
	}

	public long getValue() {
		return (long) vladimir.getInt(counterAddress);
	}

}
