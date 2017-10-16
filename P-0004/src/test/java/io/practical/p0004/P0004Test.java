package io.practical.p0004;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runners.model.RunnerScheduler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class P0004Test {

//	@Test
	public void dotestNotSynchronized() throws Exception {
		// @formatter:off
		// Options opt = new
		// OptionsBuilder().include(IncrementorNotSynchronized.class.getSimpleName()).forks(4).build();
		// @formatter:on
		ExecutorService executorServ = Executors.newFixedThreadPool(4);
		IncrementorNotSynchronized ins = new IncrementorNotSynchronized();
		ThreadIncrementor th = new ThreadIncrementor(ins);
		for (int i = 0; i < 1000; i++)
			executorServ.execute(th);
		executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
		System.out.println("dotestNotSynchronized  END: " + ins.getValue());
	}

//	@Test
	public void dotestMethodSynchronized() throws Exception {
		ExecutorService executorServ = Executors.newFixedThreadPool(4);
		IncrementorMethodSynchronized ins = new IncrementorMethodSynchronized();
		ThreadIncrementor th = new ThreadIncrementor(ins);
		for (int i = 0; i < 1000; i++)
			executorServ.execute(th);
		executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
		System.out.println("dotestMethodSynchronized  END: " + ins.getValue());
	}

//	@Test
	public void dotestBlocSynchronized() throws Exception {
		ExecutorService executorServ = Executors.newFixedThreadPool(4);
		IncrementorBlocSynchronized ins = new IncrementorBlocSynchronized();
		ThreadIncrementor th = new ThreadIncrementor(ins);
		for (int i = 0; i < 1000; i++)
			executorServ.execute(th);
		executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
		System.out.println("dotestBlocSynchronized  END: " + ins.getValue());
	}

//	@Test
	public void dotestAtomicSynchronized() throws Exception {
		ExecutorService executorServ = Executors.newFixedThreadPool(4);
		IncrementorAtomicSynchronized ins = new IncrementorAtomicSynchronized();
		ThreadIncrementor th = new ThreadIncrementor(ins);
		for (int i = 0; i < 1000; i++)
			executorServ.execute(th);
		executorServ.awaitTermination(1500, TimeUnit.MILLISECONDS);
		System.out.println("dotestAtomicSynchronized  END: " + ins.getValue());
	}
	
	@Test
	public void benchmark1() throws RunnerException {

		// @formatter:off
		 Options opt = new OptionsBuilder().include(IncrementorBenchmark.class.getSimpleName()).forks(1).build();
		// @formatter:on

		 new Runner(opt).run();
	}
}
