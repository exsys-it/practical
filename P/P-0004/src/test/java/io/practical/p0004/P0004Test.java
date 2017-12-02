package io.practical.p0004;

import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class P0004Test {

	@Test
	public void benchmark1() throws RunnerException {

		// @formatter:off
		 Options opt = new OptionsBuilder().include(IncrementorBenchmark.class.getSimpleName()).forks(1).build();
		// @formatter:on

		 new Runner(opt).run();
	}
}
