package org.koike.shuji


package object util {
  implicit class PrettyPrint[A](a: A) {
    def pp: A = {
      Logger.pp.info(a.toString)
      a
    }
  }

  implicit class Tap[A](a: A) {
    def tap(fn: A => Unit): A = {
      fn(a)
      a
    }
  }
}
