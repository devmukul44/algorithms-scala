package com.embibe.dsl.adhoc

/** https://www.geeksforgeeks.org/making-elements-distinct-sorted-array-minimum-increments/
  *
  */
object minsum {
  def main(args: Array[String]): Unit = {

    /** o(n)
      *
      * @param arr
      * @return
      */
    def minSum(arr: Array[Int]) = {
      val n = arr.size
      var sum = arr(0)
      var prev = arr(0)
      var i = 1
      while (i < n) {
        if (arr(i) <= prev) {
          prev = prev + 1
          sum = sum + prev
        }
        else {
          sum = sum + arr(i)
          prev = arr(i)
        }
        i += 1
      }
      sum
    }

    /** o(n2)
      *
      * @param arr
      * @param n
      * @return
      */
    def minSum1(arr: Array[Int]) = {
      val n = arr.size
      var sum = arr(0)
      var i = 1
      while ( {
        i < n
      }) {
        if (arr(i) == arr(i - 1)) { // While current element is same as
          // previous or has become smaller
          // than previous.
          var j = i
          while ( {
            j < n && arr(j) <= arr(j - 1)
          }) {
            arr(j) = arr(j) + 1
            j += 1
          }
        }
        sum = sum + arr(i)

        {
          i += 1; i - 1
        }
      }
      sum
    }

    /** https://stackoverflow.com/questions/38384537/minimum-unique-array-sum
      *
      * @param arr
      * @return
      */
    def minUniqueSum(arr: Array[Int]) = {
      val sortedArr = arr.sorted
      val n = sortedArr.length
      var sum = sortedArr(0)
      var prev = sortedArr(0)
      var i = 1
      while (i < n) {
        var curr = sortedArr(i)
        if (prev >= curr) curr = prev + 1
        sum += curr
        prev = curr
        i += 1
      }
      sum
    }

  }
}
