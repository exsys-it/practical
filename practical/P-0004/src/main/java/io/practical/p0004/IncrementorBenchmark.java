package io.practical.p0004;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import io.practical.p0004.incrementor.Incrementor;
import io.practical.p0004.incrementor.IncrementorAtomicSynchronized;
import io.practical.p0004.incrementor.IncrementorBlocSynchronized;
import io.practical.p0004.incrementor.IncrementorMethodSynchronized;
import io.practical.p0004.incrementor.IncrementorNotSynchronized;
import io.practical.p0004.thread.ThreadIncrementor;

@State(Scope.Thread)
public class IncrementorBenchmark {

	public Incrementor notSynchronized = new IncrementorNotSynchronized();
	public Incrementor method = new IncrementorMethodSynchronized();
	public Incrementor bloc = new IncrementorBlocSynchronized();
	public Incrementor atomic = new IncrementorAtomicSynchronized();

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void increment1MnotSynchronizedMonoThread() {
		for (int i = 0; i < 1_000_000; i++) {
			notSynchronized.inc();
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void increment1MmethodMonoThread() {
		for (int i = 0; i < 1_000_000; i++) {
			method.inc();
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void increment1MblocMonoThread() {
		for (int i = 0; i < 1_000_000; i++) {
			bloc.inc();
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void increment1MatomicMonoThread() {
		for (int i = 0; i < 1_000_000; i++) {
			atomic.inc();
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void increment1MnotSynchronizedMultiThread() {
		try {
			ExecutorService executorServ = Executors.newFixedThreadPool(4);
			CountDownLatch latch = new CountDownLatch(1_000_000);
			ThreadIncrementor th = new ThreadIncrementor(notSynchronized, latch);
			for (int i = 0; i < 1_000_000; i++)
				executorServ.execute(th);
			latch.await();
			// executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void increment1MmethodMultiThread() {
		try {
			ExecutorService executorServ = Executors.newFixedThreadPool(4);
			CountDownLatch latch = new CountDownLatch(1_000_000);
			ThreadIncrementor th = new ThreadIncrementor(method, latch);
			for (int i = 0; i < 1_000_000; i++)
				executorServ.execute(th);
			latch.await();
			// executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void increment1MblocMultiThread() {
		try {
			ExecutorService executorServ = Executors.newFixedThreadPool(4);
			CountDownLatch latch = new CountDownLatch(1_000_000);
			ThreadIncrementor th = new ThreadIncrementor(bloc, latch);
			for (int i = 0; i < 1_000_000; i++)
				executorServ.execute(th);
			latch.await();
			// executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
		}
	}

	@Benchmark
	@OutputTimeUnit(TimeUnit.SECONDS)
	public void increment1MatomicMultiThread() {
		try {
			ExecutorService executorServ = Executors.newFixedThreadPool(4);
			CountDownLatch latch = new CountDownLatch(1_000_000);
			ThreadIncrementor th = new ThreadIncrementor(atomic, latch);
			for (int i = 0; i < 1_000_000; i++)
				executorServ.execute(th);
			latch.await();
			// executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
		}
	}

}
/*
 
# Run complete. Total time: 00:08:14

Benchmark                                                    Mode  Cnt   Score   Error  Units
IncrementorBenchmark.increment1MatomicMonoThread            thrpt   20  13,927 ± 1,134  ops/s
IncrementorBenchmark.increment1MatomicMultiThread           thrpt   20   2,922 ± 0,215  ops/s
IncrementorBenchmark.increment1MblocMonoThread              thrpt   20   6,725 ± 0,587  ops/s
IncrementorBenchmark.increment1MblocMultiThread             thrpt   20   2,046 ± 0,148  ops/s
IncrementorBenchmark.increment1MmethodMonoThread            thrpt   20   5,826 ± 0,229  ops/s
IncrementorBenchmark.increment1MmethodMultiThread           thrpt   20   2,199 ± 0,154  ops/s
IncrementorBenchmark.increment1MnotSynchronizedMonoThread   thrpt   20  98,101 ± 8,485  ops/s
IncrementorBenchmark.increment1MnotSynchronizedMultiThread  thrpt   20   2,685 ± 0,263  ops/s
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 495.295 sec
 */
