package algorithms.random


/** Reverse Linked List with given Interval
  *
  * Developed By Mukul Dev on 19 Jan, 2019
  */
object ReverseLinkedListInterval {
  def main(args: Array[String]): Unit = {
    val linkedList = new ReverseLinkedListInterval

    linkedList.push(9)
    linkedList.push(8)
    linkedList.push(7)
    linkedList.push(6)
    linkedList.push(5)
    linkedList.push(4)
    linkedList.push(3)
    linkedList.push(2)
    linkedList.push(1)

    println("Input Linked List")
    linkedList.printLinkedList()

    linkedList.head = linkedList.reverse(linkedList.head, 3)
    println("Reversed Linked list")
    linkedList.printLinkedList()
  }
}

class ReverseLinkedListInterval {
  var head: Node = _

  class Node(var data: Int) {
    next = null
    var next: Node = _
  }

  def reverse(head: Node, k: Int): Node = {
    var current: Node = head
    var next: Node = null
    var prev: Node = null
    var count = 0

    while ( count < k && current != null) {
      next = current.next
      current.next = prev
      prev = current
      current = next
      count += 1
    }

    if (next != null) head.next = reverse(next, k)

    prev
  }

  def push(new_data: Int): Unit = {
    val new_node = new Node(new_data)
    new_node.next = head
    head = new_node
  }

  def printLinkedList(): Unit = {
    var temp = head
    while ( temp != null) {
      print(temp.data + " ")
      temp = temp.next
    }
    println()
  }
}
