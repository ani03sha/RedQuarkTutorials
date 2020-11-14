package org.redquark.tutorials.leetcode

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    // Two pointers - fast and slow
    var newHead: ListNode? = head
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

private fun printList(node: ListNode?) {
    var newNode = node
    while (newNode != null) {
        print(newNode.`val`.toString() + " ")
        newNode = newNode.next
    }
    println()
}

fun main() {
    var head = ListNode(1)
    head.next = ListNode(2)
    head.next!!.next = ListNode(3)
    head.next!!.next!!.next = ListNode(4)
    head.next!!.next!!.next!!.next = ListNode(5)
    printList(removeNthFromEnd(head, 2))

    head = ListNode(1)
    printList(removeNthFromEnd(head, 1))

    head = ListNode(1)
    head.next = ListNode(2)
    printList(removeNthFromEnd(head, 1))
}

