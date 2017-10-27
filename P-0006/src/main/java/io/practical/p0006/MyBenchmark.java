package io.practical.p0006;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class MyBenchmark {

	public MyBenchmark() {
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void increment1MblocMultiThread() {
		try {
			Counter counter = new Counter();
			ExecutorService executorServ = Executors.newFixedThreadPool(1);
			CountDownLatch latch = new CountDownLatch(100_000);
			IncrementorThread th = new IncrementorThread(counter, latch);
			for (int i = 0; i < 100_000; i++)
				executorServ.execute(th);
			latch.await();
		} catch (InterruptedException e) {
		}
	}

}
