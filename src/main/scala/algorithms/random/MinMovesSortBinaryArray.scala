package com.embibe.dsl.adhoc

/** https://www.geeksforgeeks.org/minimum-swaps-required-sort-binary-array/
  *
  *
  */
object MinMovesSortBinaryArray {
  def main(args: Array[String]): Unit = {



    def findMinSwaps(avg: Array[Int]) = {
      val n = avg.size
      val noOfZeroes = new Array[Int](n)
      var i = 0
      var count = 0
      noOfZeroes(n - 1) = 1 - avg(n - 1)
      i = n - 2
      while (i >= 0) {
        noOfZeroes(i) = noOfZeroes(i + 1)
        if (avg(i) == 0) {
          noOfZeroes(i) += 1; noOfZeroes(i) - 1
        }
        i -= 1
      }
      i = 0
      while (i < n) {
        if (avg(i) == 1) count += noOfZeroes(i)
        i += 1
      }
      count
    }


  }
}
