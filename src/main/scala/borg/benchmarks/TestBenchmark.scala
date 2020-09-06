package borg.benchmarks

import borg.FizzBuzz
import org.openjdk.jmh.annotations.Benchmark

class TestBenchmark {

  @Benchmark
  def test1(): String = FizzBuzz(100).get

}
