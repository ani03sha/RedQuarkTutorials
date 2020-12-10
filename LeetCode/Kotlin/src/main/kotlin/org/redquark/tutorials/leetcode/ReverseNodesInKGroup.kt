package org.redquark.tutorials.leetcode

class ReverseNodesInKGroup {

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        // Base condition
        if (head == null || k == 1) {
            return head
        }
        // Dummy node before head
        val dummy = ListNode(-1)
        // Point the next of this dummy to the current head
        dummy.next = head
        // Node to keep track of the previous node
        var previous = dummy
        // Variable to keep count of the nodes in the linked list
        var count = 0
        // Reference to the head which will be used to traverse
        var current = head
        while (current != null) {
            count++
            if (count % k == 0) {
                previous = reverse(previous, current.next)
                current = previous.next
            } else {
                current = current.next
            }
        }
        return dummy.next
    }

    private fun reverse(start: ListNode, end: ListNode?): ListNode {
        // Previous node of the current node
        val previous = start.next
        // Current node
        var current = previous!!.next
        // Next node of the current node
        var next: ListNode?
        // Loop for the whole interval
        while (current !== end) {
            // Next node of the current node
            next = current!!.next
            // Next of current will point to the previous
            current.next = start.next
            // Current node will become the previous node
            start.next = current
            // Move pointer ahead
            current = next
        }
        previous.next = end
        // Return head node of the reversed linked list
        return previous
    }

    internal fun printList(head: ListNode?) {
        var temp = head
        while (temp != null) {
            print(temp.`val`.toString() + " ")
            temp = temp.next
        }
        println()
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

fun main() {
    val r = ReverseNodesInKGroup()

    var head = ReverseNodesInKGroup.ListNode(1)
    head.next = ReverseNodesInKGroup.ListNode(2)
    head.next!!.next = ReverseNodesInKGroup.ListNode(3)
    head.next!!.next!!.next = ReverseNodesInKGroup.ListNode(4)
    head.next!!.next!!.next!!.next = ReverseNodesInKGroup.ListNode(5)
    r.printList(r.reverseKGroup(head, 2))

    head = ReverseNodesInKGroup.ListNode(1)
    head.next = ReverseNodesInKGroup.ListNode(2)
    head.next!!.next = ReverseNodesInKGroup.ListNode(3)
    head.next!!.next!!.next = ReverseNodesInKGroup.ListNode(4)
    head.next!!.next!!.next!!.next = ReverseNodesInKGroup.ListNode(5)
    r.printList(r.reverseKGroup(head, 3))

    head = ReverseNodesInKGroup.ListNode(1)
    head.next = ReverseNodesInKGroup.ListNode(2)
    head.next!!.next = ReverseNodesInKGroup.ListNode(3)
    head.next!!.next!!.next = ReverseNodesInKGroup.ListNode(4)
    head.next!!.next!!.next!!.next = ReverseNodesInKGroup.ListNode(5)
    r.printList(r.reverseKGroup(head, 1))

    head = ReverseNodesInKGroup.ListNode(1)
    r.printList(r.reverseKGroup(head, 1))
}