package io.practical.p0006;

public class Counter {

	int value;

	public Counter() {
		value = 0;
	}

	public void increment() {
		value++;
	}
	
	public int getValue() {
		return this.value;
	}
	
}
