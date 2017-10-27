package io.practical.p0006;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;

import sun.misc.Unsafe;

public class Main {

	public static void main(String[] args) throws Exception {

		Counter counter = new Counter();
		
//		Unsafe unsafe = UnsafeHelper.getUnsafe();
//		long bufferAddress = unsafe.objectFieldOffset(Counter.class.getDeclaredField("value"));
//		int vladimir = unsafe.getInt(counter, bufferAddress);
		
//		System.out.println("unsafe vladimir = " + vladimir);
		

//		vladimir = unsafe.getInt(counter, bufferAddress);
//		System.out.println("unsafe vladimir = " + vladimir);
		
//		testCounter();
//		testCounterAtomic();
		testCounterUnsafe();
		
	}
	
	public static void testCounter() throws InterruptedException {
		System.out.println("start testCounter");
		Counter counter = new Counter();
		
		CountDownLatch latch = new CountDownLatch(100_000);
		for (int i = 0; i<100_000; i++)
		ForkJoinPool.commonPool().execute(new IncrementorThread(counter, latch));
		
		System.out.println("before await:" + counter.getValue());
		latch.await();
		
		System.out.println("after await:"+counter.getValue());
		System.out.println("end\n");
	}
	

	public static void testCounterAtomic() throws InterruptedException {
		System.out.println("start testCounterAtomic");
		CounterAtomic counter = new CounterAtomic();
		
		CountDownLatch latch = new CountDownLatch(100_000);
		for (int i = 0; i<100_000; i++)
		ForkJoinPool.commonPool().execute(new IncrementorAtomicThread(counter, latch));
		
		System.out.println("before await:" + counter.getValue());
		latch.await();
		
		System.out.println("after await:"+counter.getValue());
		System.out.println("end\n");
	}
	
	public static void testCounterUnsafe() throws InterruptedException {
		System.out.println("start testCounterUnsafe");

		Unsafe unsafe = UnsafeHelper.getUnsafe();
		long counterAddres = unsafe.allocateMemory(4);
		
		System.out.println("address: " + counterAddres);
		System.out.println("counter value:" +  unsafe.getInt(counterAddres));
		unsafe.putInt(counterAddres, 0);//no need
		System.out.println("new set value:" +  unsafe.getInt(counterAddres));
		
		CounterUnsafe counter = new CounterUnsafe(unsafe, counterAddres);
//		
		CountDownLatch latch = new CountDownLatch(100_000);
		for (int i = 0; i<100_000; i++)
		ForkJoinPool.commonPool().execute(new IncrementorUnsafeThread(counter, latch));
		System.out.println("before await:" + counter.getValue());
		latch.await();
		
		System.out.println("after await:"+counter.getValue());
		System.out.println("end\n");
	}

}
