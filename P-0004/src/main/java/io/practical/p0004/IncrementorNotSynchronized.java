package io.practical.p0004;

public class IncrementorNotSynchronized implements Incrementor {
	
	Long count = 0L;
	
	public IncrementorNotSynchronized (){
	}
	
	public void inc() {
		count++;
	}
	
	public long getValue() {
		return count;
	}

}
