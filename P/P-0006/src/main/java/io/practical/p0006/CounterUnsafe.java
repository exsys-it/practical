package io.practical.p0006;


import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public class CounterUnsafe {

	long counterAddress;
	long counterValueOffset;
	Unsafe unsafe;
	Integer counter;

	public CounterUnsafe(Unsafe unsafe, long counterAddres) {
		this.counterAddress = counterAddres;
		this.unsafe = unsafe;
		this.counter = 0;
		try {
			counterValueOffset = unsafe.objectFieldOffset(Integer.class.getDeclaredField("value"));
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

	}

	public void increment() {
		int oldValue = 0;
		int newValue;
		do {
			oldValue = unsafe.getInt(counter, counterValueOffset);
			newValue = oldValue + 1;
		} while (!unsafe.compareAndSwapInt(counter, counterValueOffset, oldValue, newValue));
	}

	public long getValue() {
		return (long) unsafe.getInt(counter, counterValueOffset);
	}

}
