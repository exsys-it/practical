package io.practical.p0007;

import org.junit.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class ParserBenchmarkTest {
	
//	est
	public void dotest() throws Exception {
		// @formatter:off
		 Options opt = new
		 OptionsBuilder().include(ParserBenchmark.class.getSimpleName()).forks(1).build();
		// @formatter:on

		new Runner(opt).run();
	}
}
