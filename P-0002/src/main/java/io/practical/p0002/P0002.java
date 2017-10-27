package io.practical.p0002;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeoutException;

public class P0002 {

	public static void main(String[] args)
	        throws IOException, InterruptedException, BrokenBarrierException, TimeoutException {
		incrementCountDown();
	}

	public static void incrementCountDown() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(4);
		System.out.println("latch count before thread run = " + latch.getCount());

		for (int i = 0; i < 4; i++) {
			ForkJoinPool.commonPool().execute(new IncrementerThread(i, latch));
		}
		System.out.println("latch count before await = " + latch.getCount());
		latch.await();
		System.out.println("latch count = " + latch.getCount());

	}
}
