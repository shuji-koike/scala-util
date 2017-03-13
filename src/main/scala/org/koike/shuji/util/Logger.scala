package org.koike.shuji.util

import org.slf4j.LoggerFactory

trait Logger {
  protected lazy val logger: org.slf4j.Logger = LoggerFactory.getLogger(getClass)

  protected def pp[A <: Any](any: A): A = {
    if (any != null) {
      Logger.pp.info(any.toString)
    } else {
      Logger.pp.warn("null")
    }
    any
  }

  protected def logging[A](f: => String)(a: A): A = {
    logger.info(f)
    a
  }
}

object Logger {
  val default: org.slf4j.Logger = LoggerFactory.getLogger("StaticLogger")
  val pp: org.slf4j.Logger = LoggerFactory.getLogger("pp")

  trait Static extends Logger {
    protected override lazy val logger: org.slf4j.Logger = default
  }

  abstract class WithName(loggerName: String) extends Logger {
    protected override lazy val logger: org.slf4j.Logger = LoggerFactory.getLogger(loggerName)
  }
}
