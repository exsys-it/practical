package io.practical.p0006;

public class Counter {

	int value;

	public Counter() {
		value = 0;
	}

	public int getValue() {
		return this.value;
	}

	public void increment() {
		value++;
	}
}
