package io.practical.p0004;

public class IncrementorNotSynchronized {
	
	Integer count = 0;
	
	public IncrementorNotSynchronized (){
	}
	
	public void inc() {
		count++;
	}
	
	public int getValue() {
		return count;
	}

}
