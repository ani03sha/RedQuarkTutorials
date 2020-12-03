"""
@author - Anirudh Sharma
"""
from typing import List


class ListNode:
    def __init__(self, val=0, nextNode=None):
        self.val = val
        self.next = nextNode


class MergeKSortedList:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        # Base condition
        if lists is None or len(lists) == 0:
            return None
        return self.mergeLists(lists, 0, len(lists) - 1)

    def mergeLists(self, lists, start, end):
        # Base condition
        if start == end:
            return lists[start]
        # Mid of lists of lists
        mid = start + (end - start) // 2
        # Recursive calls for left sublist
        left = self.mergeLists(lists, start, mid)
        # Recursive call for right sublist
        right = self.mergeLists(lists, mid + 1, end)
        # Merge these sorted lists
        return self.merge(left, right)

    @staticmethod
    def merge(left, right):
        # Dummy node
        head = ListNode(-1)
        # Temp node
        temp = head
        # Loop until any of the lists becomes null
        while left is not None and right is not None:
            # Choose the smaller value from left and right lists
            if left.val < right.val:
                temp.next = left
                left = left.next
            else:
                temp.next = right
                right = right.next
            temp = temp.next
        # Take all nodes from left list if remaining
        while left is not None:
            temp.next = left
            left = left.next
            temp = temp.next
        # Take all nodes from right list if remaining
        while right is not None:
            temp.next = right
            right = right.next
            temp = temp.next
        return head.next


if __name__ == '__main__':
    m = MergeKSortedList()
    head1 = ListNode(1)
    head1.next = ListNode(4)
    head1.next.next = ListNode(5)

    head2 = ListNode(1)
    head2.next = ListNode(3)
    head2.next.next = ListNode(4)

    head3 = ListNode(2)
    head3.next = ListNode(6)

    result = m.mergeKLists([head1, head2, head3])

    while result is not None:
        print(result.val, end=" ")
        result = result.next
