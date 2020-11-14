package org.redquark.tutorials.leetcode

private fun removeNthFromEnd(head: ListNode19?, n: Int): ListNode19? {
    // Two pointers - fast and slow
    var newHead: ListNode19? = head
    var slow = newHead
    var fast = newHead
    // Move fast pointer n steps ahead
    for (i in 0 until n) {
        if (fast?.next == null) {
            // If n is equal to the number of nodes, delete the head node
            if (i == n - 1) {
                newHead = newHead!!.next
            }
            return newHead
        }
        fast = fast.next
    }
    // Loop until we reach to the end.
    // Now we will move both fast and slow pointers
    while (fast?.next != null) {
        slow = slow!!.next
        fast = fast.next
    }
    // Delink the nth node from last
    if (slow?.next != null) {
        slow.next = slow.next!!.next
    }
    return newHead
}

private fun printList(node: ListNode19?) {
    var newNode = node
    while (newNode != null) {
        print(newNode.`val`.toString() + " ")
        newNode = newNode.next
    }
    println()
}

fun main() {
    var head = ListNode19(1)
    head.next = ListNode19(2)
    head.next!!.next = ListNode19(3)
    head.next!!.next!!.next = ListNode19(4)
    head.next!!.next!!.next!!.next = ListNode19(5)
    printList(removeNthFromEnd(head, 2))

    head = ListNode19(1)
    printList(removeNthFromEnd(head, 1))

    head = ListNode19(1)
    head.next = ListNode19(2)
    printList(removeNthFromEnd(head, 1))
}

/**
 * This class represents each node in the linked list
 */
internal class ListNode19(val `val`: Int) {
    var next: ListNode19? = null
}

