package org.koike.shuji.util

import scala.util.{Failure, Success, Try}


trait Retry extends Logger.Static {

  @annotation.tailrec
  protected final def retry[A](n: Int)(a: => A): A = {
    Try(a) match {
      case Success(x) => x
      case Failure(e) if n > 0 =>
        logger.warn(s"RETRY n=$n error=$e")
        retry(n - 1)(a)
      case Failure(e) =>
        logger.error(s"RETRY limit reached error=$e")
        throw e
    }
  }
}
