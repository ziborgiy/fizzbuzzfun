package borg

import scala.annotation.tailrec

trait FizzBuzz {
  def get: String
}

object FizzBuzz {

  def apply(n: Int): FizzBuzz = new FizzBuzz {
    override def get: String ={
      implicit class IntOps(n: Int) {
        private def createVectorFrom(number: Int): Seq[Int] = {
          number.toString.flatMap(_ :: Nil).map(_.toString.toInt)
        }

        def devided3: Boolean = createVectorFrom(n).sum % 3 == 0

        def devided5: Boolean = createVectorFrom(n).last == 5 || createVectorFrom(n).last == 0

        def devided3And5: Boolean = devided3 && devided5
      }

      def next(prev: (Int, String)): (Int, String) = {
        val nextIdx = prev._1 + 1
        val nextSign = nextIdx match {
          case idx if idx.devided3And5 => "Fizz Buzz"
          case idx if idx.devided3 => "Fizz"
          case idx if idx.devided5 => "Buzz"
          case idx => idx.toString
        }
        (nextIdx, nextSign)
      }

      @tailrec
      def calc(n: Int, result: Vector[(Int, String)] = Vector(1 -> "1")): Seq[(Int, String)] = {
        if (n == 0) result else calc(n - 1, result :+ next(result.last))
      }

      calc(n).map(_._2).mkString(", ")
    }
  }
}
