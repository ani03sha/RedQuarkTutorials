"""
@author - Anirudh Sharma
"""


class ListNode:
    def __init__(self, val=0, nextNode=None):
        self.val = val
        self.next = nextNode


class SwapNodesInPairs:
    def swapPairs(self, head: ListNode) -> ListNode:
        # Dummy node
        dummy = ListNode(0)
        # Point the next of dummy node to the head
        dummy.next = head
        # This node will be used to traverse the list
        current = dummy
        # Loop until we reach to the second last node
        while current.next is not None and current.next.next is not None:
            # First node of the pair
            first = current.next
            # Second node of the pair
            second = current.next.next
            # Point the next of first node to the node after second node
            first.next = second.next
            # Now the current node's next should be the second node
            current.next = second
            # Linking the original second node to the first node
            current.next.next = first
            # Move the pointer two nodes ahead
            current = current.next.next
        return dummy.next

    def printList(self, head):
        temp = head
        while temp is not None:
            print(temp.val, end=" ")
            temp = temp.next
        print()


if __name__ == '__main__':
    s = SwapNodesInPairs()
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    s.printList(s.swapPairs(head))

    head = ListNode(1)
    s.printList(s.swapPairs(head))
