package org.koike.shuji.util

import org.scalatest._

import scala.util.{Failure, Try}

class LoanPatternSpec extends FlatSpec with Matchers {

  class LoanPatternExample extends LoanPattern {
    def useCase(closeable: Closeable) = {
      using(closeable) { c =>
        c.meow()
      }
    }

    def errorCase(closeable: Closeable) = {
      using(closeable) { c =>
        sys.error("OOPS!!!")
      }
    }
  }

  class Closeable extends java.io.Closeable {
    var closed = false
    def meow() = {
      // meow meow meow
      assert(!closed)
    }
    def close() = {
      closed = true
    }
  }

  "using" should "close" in {
    val closeable = new Closeable
    val example = new LoanPatternExample
    example.useCase(closeable)
    closeable.closed should be (true)
  }

  "using" should "pass through exceptions and close" in {
    val closeable = new Closeable
    val example = new LoanPatternExample
    val result = Try {
      example.errorCase(closeable)
    }
    result.isFailure should be (true)
    closeable.closed should be (true)
  }
}
