package io.practical.p0002;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

public class P0002 {

	private static final int COUNT = 1_000;

	public static void main(String[] args)
			throws IOException, InterruptedException, BrokenBarrierException, TimeoutException {
		// http://tutorials.jenkov.com/java-util-concurrent/cyclicbarrier.html
		increment();
	}

	public static void increment() throws InterruptedException, BrokenBarrierException, TimeoutException {
		// List<IncrementerAction> subtasks = new ArrayList<>();
		// CyclicBarrier barrier = new CyclicBarrier(COUNT * 4);
		// IncrementerAction ia1 = new IncrementerAction(1, 0, COUNT, barrier);
		// IncrementerAction ia2 = new IncrementerAction(1, 2000, COUNT,
		// barrier);
		// IncrementerAction ia3 = new IncrementerAction(1, 9999, COUNT,
		// barrier);
		// IncrementerAction ia4 = new IncrementerAction(1, 1990, COUNT,
		// barrier);
		IncrementerAction ia1 = new IncrementerAction(1, 0, COUNT);
		IncrementerAction ia2 = new IncrementerAction(1, 2000, COUNT);
		IncrementerAction ia3 = new IncrementerAction(1, 9999, COUNT);
		IncrementerAction ia4 = new IncrementerAction(1, 1990, COUNT);

		// subtasks.add(ia1);
		// subtasks.add(ia2);
		// subtasks.add(ia3);
		// subtasks.add(ia4);
		// ForkJoinPool.commonPool().execute(subtasks);
		ia1.fork();
		ia2.fork();
		ia3.fork();
		ia4.fork();
		System.out.println("all tasks invoked");
		ia1.join();
		ia2.join();
		ia3.join();
		ia4.join();
		System.out.print("program await ...");
//		barrier.await();
		// await(3, TimeUnit.SECONDS);
		System.out.println("program await ... finished");

	}
}
