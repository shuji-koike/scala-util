package org.koike.shuji.util

import java.io.Closeable


trait LoanPattern {
  def using[A <:Closeable, B](closeable: A)(f: A => B): B = {
    try {
      f(closeable)
    } finally {
      closeable.close()
    }
  }
}

object LoanPattern extends LoanPattern
