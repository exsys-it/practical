package io.practical.p0004;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;

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
//			executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
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
//			executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
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
//			executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
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
//			executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
		}
	}

}
