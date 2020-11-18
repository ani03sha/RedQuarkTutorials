package org.redquark.tutorials.leetcode

fun mergeTwoLists(l1: ListNode21?, l2: ListNode21?): ListNode21? {
    var list1 = l1
    var list2 = l2
    // Check if ant of the lists are null
    if (list1 == null) {
        return list2
    }
    if (list2 == null) {
        return list1
    }
    // Head of the result list
    val head: ListNode21
    // Pointer for the resultant list
    var temp: ListNode21?
    // Choose head which is smaller of the two lists
    if (list1.`val` < list2.`val`) {
        head = ListNode21(list1.`val`)
        temp = head
        list1 = list1.next
    } else {
        head = ListNode21(list2.`val`)
        temp = head
        list2 = list2.next
    }
    // Loop until any of the list becomes null
    while (list1 != null && list2 != null) {
        if (list1.`val` < list2.`val`) {
            temp!!.next = ListNode21(list1.`val`)
            list1 = list1.next
        } else {
            temp!!.next = ListNode21(list2.`val`)
            list2 = list2.next
        }
        temp = temp.next
    }
    // Add all the nodes in l1, if remaining
    while (list1 != null) {
        temp!!.next = ListNode21(list1.`val`)
        list1 = list1.next
        temp = temp.next
    }
    // Add all the nodes in l2, if remaining
    while (list2 != null) {
        temp!!.next = ListNode21(list2.`val`)
        list2 = list2.next
        temp = temp.next
    }
    return head
}

fun main() {
    val head1 = ListNode21(1)
    head1.next = ListNode21(2)
    head1.next!!.next = ListNode21(4)
    var head2 = ListNode21(1)
    head2.next = ListNode21(3)
    head2.next!!.next = ListNode21(4)
    mergeTwoLists(head1, head2)?.let { printList(it) }
    mergeTwoLists(null, null)?.let { printList(it) }
    head2 = ListNode21(0)
    mergeTwoLists(null, head2)?.let { printList(it) }
}

private fun printList(mergedList: ListNode21) {
    var list: ListNode21? = mergedList
    while (list != null) {
        print(list.`val`.toString() + " ")
        list = list.next
    }
    println()
}

class ListNode21(var `val`: Int) {
    var next: ListNode21? = null
}