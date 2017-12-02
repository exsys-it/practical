package io.practical.p0006;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
@State(Scope.Thread)
public class MyBenchmark {

	public MyBenchmark(){
		
	}
	
	@State(Scope.Thread)
	public static class StateUnsafe {
		Unsafe unsafe = UnsafeHelper.getUnsafe();
		CounterUnsafe counter = new CounterUnsafe(unsafe, 0);
		CountDownLatch latch = new CountDownLatch(100_000);
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void increment1MblocMultiThread(StateUnsafe state) throws Exception{
		try {
						
			for (int i = 0; i < 100_000; i++)
				ForkJoinPool.commonPool().execute(new IncrementorUnsafeThread(state.counter, state.latch));
			
			state.latch.await();
			
		} catch (InterruptedException e) {
		}
	}
}
/*
 -------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running io.practical.p0006.P0006Test
# JMH version: 1.19
# VM version: JDK 1.8.0_121, VM 25.121-b13
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_121.jdk/Contents/Home/jre/bin/java
# VM options: <none>
# Warmup: 20 iterations, 1 s each
# Measurement: 20 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: io.practical.p0006.MyBenchmark.increment1MblocMultiThread

# Run progress: 0,00% complete, ETA 00:00:40
# Fork: 1 of 1
# Warmup Iteration   1: 35,336 ops/s
# Warmup Iteration   2: 35,644 ops/s
# Warmup Iteration   3: 37,728 ops/s
# Warmup Iteration   4: 35,857 ops/s
# Warmup Iteration   5: 36,519 ops/s
# Warmup Iteration   6: 40,541 ops/s
# Warmup Iteration   7: 36,578 ops/s
# Warmup Iteration   8: 31,749 ops/s
# Warmup Iteration   9: 43,708 ops/s
# Warmup Iteration  10: 40,006 ops/s
# Warmup Iteration  11: 42,441 ops/s
# Warmup Iteration  12: 37,370 ops/s
# Warmup Iteration  13: 41,548 ops/s
# Warmup Iteration  14: 36,213 ops/s
# Warmup Iteration  15: 33,230 ops/s
# Warmup Iteration  16: 34,744 ops/s
# Warmup Iteration  17: 34,807 ops/s
# Warmup Iteration  18: 40,378 ops/s
# Warmup Iteration  19: 41,539 ops/s
# Warmup Iteration  20: 40,589 ops/s
Iteration   1: 40,291 ops/s
Iteration   2: 38,804 ops/s
Iteration   3: 39,708 ops/s
Iteration   4: 38,801 ops/s
Iteration   5: 38,735 ops/s
Iteration   6: 41,518 ops/s
Iteration   7: 39,488 ops/s
Iteration   8: 44,535 ops/s
Iteration   9: 38,782 ops/s
Iteration  10: 36,789 ops/s
Iteration  11: 39,421 ops/s
Iteration  12: 37,573 ops/s
Iteration  13: 41,481 ops/s
Iteration  14: 40,905 ops/s
Iteration  15: 41,898 ops/s
Iteration  16: 41,384 ops/s
Iteration  17: 40,645 ops/s
Iteration  18: 39,598 ops/s
Iteration  19: 40,033 ops/s
Iteration  20: 41,946 ops/s


Result "io.practical.p0006.MyBenchmark.increment1MblocMultiThread":
  40,117 ±(99.9%) 1,523 ops/s [Average]
  (min, avg, max) = (36,789, 40,117, 44,535), stdev = 1,753
  CI (99.9%): [38,594, 41,639] (assumes normal distribution)


# Run complete. Total time: 00:00:41

Benchmark                                Mode  Cnt   Score   Error  Units
MyBenchmark.increment1MblocMultiThread  thrpt   20  40,117 ± 1,523  ops/s
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 41.901 sec
*/
