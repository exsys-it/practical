package io.practical.p0004;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IncrementorBlocSynchronized {

	Integer count = 0;
	
	public IncrementorBlocSynchronized() {
	}

	public void inc() {
		Lock l = new java.util.concurrent.locks.ReentrantLock();
		try {
			l.tryLock(100, TimeUnit.MILLISECONDS);
			try {
				count++;
			} finally {
			    l.unlock();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// synchronized (count) {
		// count++;
		// }
	}

	public int getValue() {
		return count;
	}

}
