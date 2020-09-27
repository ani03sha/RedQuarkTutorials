package org.redquark.tutorials.leetcode

/**
 * @author Anirudh Sharma
 */
private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var head1 = l1
    var head2 = l2
    // Head of the new linked list - this is the head of the resultant list
    var head: ListNode? = null
    // Reference of head which is null at this point
    var temp: ListNode? = null
    // Carry
    var carry = 0
    // Loop for the two lists
    while (head1 != null || head2 != null) {
        // At the start of each iteration, we should add carry from the last iteration
        var sum = carry
        // Since the lengths of the lists may be unequal, we are checking if the
        // current node is null for one of the lists
        if (head1 != null) {
            sum += head1.`val`
            head1 = head1.next
        }
        if (head2 != null) {
            sum += head2.`val`
            head2 = head2.next
        }
        // At this point, we will add the total sum % 10 to the new node
        // in the resultant list
        val node = ListNode(sum % 10)
        // Carry to be added in the next iteration
        carry = sum / 10
        // If this is the first node or head
        if (temp == null) {
            head = node
            temp = head
        } else {
            temp.next = node
            temp = temp.next
        }
    }
    // After the last iteration, we will check if there is carry left
    // If it's left then we will create a new node and add it
    if (carry > 0) {
        temp!!.next = ListNode(carry)
    }
    return head
}

fun main() {
    val head1 = ListNode(2)
    head1.next = ListNode(4)
    head1.next!!.next = ListNode(3)

    val head2 = ListNode(5)
    head2.next = ListNode(6)
    head2.next!!.next = ListNode(4)

    var result = addTwoNumbers(head1, head2)

    while (result != null) {
        print(result.`val`.toString() + " ")
        result = result.next
    }
}

/**
 * This class represents each node in the linked list
 */
internal class ListNode(val `val`: Int) {
    var next: ListNode? = null
}