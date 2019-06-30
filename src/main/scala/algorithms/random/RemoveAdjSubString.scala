package com.embibe.dsl.adhoc


/** https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
  *
  */
object RemoveAdjSubString {

  def removeUtil(str: String, last_removed: Char): String = {
    var str1 = str
    var lastRemoved = last_removed
    if (str1.length == 0 || str1.length == 1) return str1

    if (str1.charAt(0) == str1.charAt(1)) {
      lastRemoved = str1.charAt(0)
      while (str1.length > 1 && str1.charAt(0) == str1.charAt(1)) str1 = str1.substring(1, str1.length)
      str1 = str1.substring(1, str1.length)
      return removeUtil(str1, lastRemoved)
    }

    val rem_str = removeUtil(str1.substring(1, str1.length), lastRemoved)

    if (rem_str.length != 0 && rem_str.charAt(0) == str1.charAt(0)) {
      lastRemoved = str1.charAt(0)
      return rem_str.substring(1, rem_str.length) // Remove first character
    }

    if (rem_str.length == 0 && lastRemoved == str1.charAt(0)) return rem_str

    str1.charAt(0) + rem_str
  }

  private[adhoc] def remove(str: String) = {
    val last_removed = '\0'
    removeUtil(str, last_removed)
  }

  // Driver code
  def main(args: Array[String]): Unit = {
    val str1 = "geeksforgeeg"
    System.out.println(remove(str1))
    val str2 = "azxxxzy"
    System.out.println(remove(str2))
    val str3 = "caaabbbaac"
    System.out.println(remove(str3))
    val str4 = "gghhg"
    System.out.println(remove(str4))
    val str5 = "aaaacddddcappp"
    System.out.println(remove(str5))
    val str6 = "aaaaaaaaaa"
    System.out.println(remove(str6))
    val str7 = "qpaaaaadaaaaadprq"
    System.out.println(remove(str7))
    val str8 = "acaaabbbacdddd"
    System.out.println(remove(str8))
  }
}