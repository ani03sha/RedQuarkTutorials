package org.redquark.tutorials.leetcode

class MergeKSortedLists {

    internal fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        // Base condition
        return if (lists.isEmpty()) {
            null
        } else mergeKLists(lists, 0, lists.size - 1)
    }

    private fun mergeKLists(lists: Array<ListNode?>, start: Int, end: Int): ListNode? {
        if (start == end) {
            return lists[start]
        }
        // Mid of list of lists
        val mid = start + (end - start) / 2
        // Recursive call for left sublist
        val left = mergeKLists(lists, start, mid)
        // Recursive call for right sublist
        val right = mergeKLists(lists, mid + 1, end)
        // Merge the left and right sublist
        return merge(left, right)
    }

    private fun merge(left: ListNode?, right: ListNode?): ListNode? {
        // Create a dummy node
        var leftNode = left
        var rightNode = right
        val head = ListNode(-1)
        // Temp node
        var temp: ListNode? = head
        // Loop until any of the list becomes null
        while (leftNode != null && rightNode != null) {
            // Choose the value from the left and right which is smaller
            if (leftNode.`val` < rightNode.`val`) {
                temp!!.next = leftNode
                leftNode = leftNode.next
            } else {
                temp!!.next = rightNode
                rightNode = rightNode.next
            }
            temp = temp.next
        }
        // Take all nodes from left list if remaining
        while (leftNode != null) {
            temp!!.next = leftNode
            leftNode = leftNode.next
            temp = temp.next
        }
        // Take all nodes from right list if remaining
        while (rightNode != null) {
            temp!!.next = rightNode
            rightNode = rightNode.next
            temp = temp.next
        }
        return head.next
    }

    internal class ListNode(val `val`: Int) {
        var next: ListNode? = null
    }
}

fun main() {
    val m = MergeKSortedLists()
    val head1 = MergeKSortedLists.ListNode(1)
    head1.next = MergeKSortedLists.ListNode(4)
    head1.next!!.next = MergeKSortedLists.ListNode(5)
    val head2 = MergeKSortedLists.ListNode(1)
    head2.next = MergeKSortedLists.ListNode(3)
    head2.next!!.next = MergeKSortedLists.ListNode(4)
    val head3 = MergeKSortedLists.ListNode(2)
    head3.next = MergeKSortedLists.ListNode(6)
    var result = m.mergeKLists(arrayOf(head1, head2, head3))
    while (result != null) {
        print(result.`val`.toString() + " ")
        result = result.next
    }
}