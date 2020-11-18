package org.redquark.tutorials.leetcode;

/**
 * @author Anirudh Sharma
 */
public class MergeTwoSortedLists {

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Check if ant of the lists are null
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // Head of the result list
        ListNode head;
        // Pointer for the resultant list
        ListNode temp;
        // Choose head which is smaller of the two lists
        if (l1.val < l2.val) {
            temp = head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            temp = head = new ListNode(l2.val);
            l2 = l2.next;
        }
        // Loop until any of the list becomes null
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        // Add all the nodes in l1, if remaining
        while (l1 != null) {
            temp.next = new ListNode(l1.val);
            l1 = l1.next;
            temp = temp.next;
        }
        // Add all the nodes in l2, if remaining
        while (l2 != null) {
            temp.next = new ListNode(l2.val);
            l2 = l2.next;
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        printList(mergeTwoLists(head1, head2));

        printList(mergeTwoLists(null, null));

        head2 = new ListNode(0);
        printList(mergeTwoLists(null, head2));
    }

    private static void printList(ListNode mergedList) {
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
