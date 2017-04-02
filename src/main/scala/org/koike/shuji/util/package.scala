package org.koike.shuji

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}


package object util {
  implicit class PrettyPrint[A](a: A) {
    def pp: A = {
      Logger.pp.info(a.toString)
      a
    }
  }

  implicit class Tap[A](a: A) {
    def tap(fn: A => Any): A = {
      fn(a)
      a
    }
  }

  implicit class AwaitFuture[A](future: Future[A]) {
    def await(duration: Duration = Duration.Inf): A = {
      Await.result(future, duration)
    }
  }
}
