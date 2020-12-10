"""
@author - Anirudh Sharma
"""
from typing import Optional


class ListNode:
    def __init__(self, val=0, nextNode=None):
        self.val = val
        self.next = nextNode


class ReverseNodesInKGroups:
    def reverseKGroup(self, headNode: ListNode, k: int) -> Optional[ListNode]:
        # Base condition
        if headNode is None or k == 1:
            return headNode
        # Dummy node before headNode
        dummy = ListNode(-1)
        # Point the next of this dummy node to the current headNode
        dummy.next = headNode
        # Node to keep track of the previous node
        previous = dummy
        # Variable to keep count of the nodes in the linked list
        count = 0
        # Reference to the headNode which will be used to traverse
        current = headNode
        # Loop for all the nodes in the list
        while current is not None:
            count += 1
            if count % k == 0:
                previous = self.reverseList(previous, current.next)
                current = previous.next
            else:
                current = current.next
        return dummy.next

    @staticmethod
    def reverseList(start, end):
        previous = start.next
        current = previous.next
        while current is not end:
            nextNode = current.next
            current.next = start.next
            start.next = current
            current = nextNode
        previous.next = end
        return previous

    @staticmethod
    def printList(headNode):
        temp = headNode
        while temp is not None:
            print(temp.val, end=" ")
            temp = temp.next
        print()


if __name__ == '__main__':
    r = ReverseNodesInKGroups()

    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    r.printList(r.reverseKGroup(head, 2))

    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    r.printList(r.reverseKGroup(head, 3))

    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    r.printList(r.reverseKGroup(head, 1))

    head = ListNode(1)
    r.printList(r.reverseKGroup(head, 1))
