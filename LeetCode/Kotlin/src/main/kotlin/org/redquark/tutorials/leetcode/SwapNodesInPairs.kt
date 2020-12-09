package org.redquark.tutorials.leetcode

class SwapNodesInPairs {

    internal fun swapPairs(head: ListNode?): ListNode? {
        // Dummy node
        val dummy = ListNode(0)
        // Point the next of dummy node to the head
        dummy.next = head
        // This node will be used to traverse the list
        var current: ListNode? = dummy
        // Loop until we reach to the second last node
        while (current!!.next != null && current.next!!.next != null) {
            // First node of the pair
            val first = current.next
            // Second node of the pair
            val second = current.next!!.next
            // Point the next of first node to the node after second node
            first!!.next = second!!.next
            // Now the current node's next should be the second node
            current.next = second
            // Linking the original second node to the first node
            current.next!!.next = first
            // Move the pointer two nodes ahead
            current = current.next!!.next
        }
        return dummy.next
    }

    internal fun printList(head: ListNode?) {
        var temp = head
        while (temp != null) {
            print(temp.`val`.toString() + " ")
            temp = temp.next
        }
        println()
    }

    internal class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

fun main() {
    val s = SwapNodesInPairs()
    var head = SwapNodesInPairs.ListNode(1)
    head.next = SwapNodesInPairs.ListNode(2)
    head.next!!.next = SwapNodesInPairs.ListNode(3)
    head.next!!.next!!.next = SwapNodesInPairs.ListNode(4)
    s.printList(s.swapPairs(head))

    s.printList(s.swapPairs(null))

    head = SwapNodesInPairs.ListNode(1)
    s.printList(s.swapPairs(head))
}