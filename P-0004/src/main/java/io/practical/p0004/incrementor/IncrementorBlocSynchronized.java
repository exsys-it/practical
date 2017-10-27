package io.practical.p0004.incrementor;

import java.util.concurrent.locks.Lock;

public class IncrementorBlocSynchronized implements Incrementor {

	Long count = 0L;

	private static final Lock l = new java.util.concurrent.locks.ReentrantLock();
//	public static final Object lock = new Object();

	public IncrementorBlocSynchronized() {
	}

	public void inc() {

		l.lock();
		try {
			count++;
		} finally {
			l.unlock();
		}
//		 synchronized (lock) {
//		 count++;
//		 }
	}

	public long getValue() {
		return count;
	}

}
