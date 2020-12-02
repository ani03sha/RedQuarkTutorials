package org.redquark.tutorials.leetcode;

/**
 * @author Anirudh Sharma
 */
public class MergeKSortedLists {

    private static ListNode mergeKLists(ListNode[] lists) {
        // Base condition
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        // Mid of list of lists
        int mid = start + (end - start) / 2;
        // Recursive call for left sublist
        ListNode left = mergeKLists(lists, start, mid);
        // Recursive call for right sublist
        ListNode right = mergeKLists(lists, mid + 1, end);
        // Merge the left and right sublist
        return merge(left, right);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        // Create a dummy node
        ListNode head = new ListNode(-1);
        // Temp node
        ListNode temp = head;
        // Loop until any of the list becomes null
        while (left != null && right != null) {
            // Choose the value from the left and right which is smaller
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        // Take all nodes from left list if remaining
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        // Take all nodes from right list if remaining
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode result = mergeKLists(new ListNode[]{head1, head2, head3});

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    static class ListNode {
        final int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
