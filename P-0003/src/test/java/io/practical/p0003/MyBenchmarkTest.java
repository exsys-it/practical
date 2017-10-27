package io.practical.p0003;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;;

public class MyBenchmarkTest {

	@Test
	public void dotest() throws Exception {
		// @formatter:off
		 Options opt = new
		 OptionsBuilder().include(MyBenchmark.class.getSimpleName()).forks(1).build();
		// @formatter:on

		 new Runner(opt).run();
	}

}
