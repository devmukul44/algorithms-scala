package algorithms.random

import scala.collection.mutable.ListBuffer

/**
  * https://crypticarticles.wordpress.com/2015/07/22/is-it-possible-hackerearth-interview-question/
  *
  */
object tupleIsPossible {
  def main(args: Array[String]): Unit = {

    def isItPossible(a: Integer, b: Integer, c: Integer, d: Integer): String = {
      var pairs = new ListBuffer[(Int, Int)]()
      pairs += ((a,b))

      while (pairs.nonEmpty) {
        val pair = pairs.remove(0)
        val key = pair._1
        val value = pair._2
        if (key == c && value == d) return "Yes"
        val sum = key + value
        if (sum <= c) pairs.+=((sum, value))
        if (sum <= d) pairs.+=((key, sum))
      }
      "No"
    }
  }
}
