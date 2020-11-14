"""
@author - Anirudh Sharma
"""


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def printList(node: ListNode):
    while node is not None:
        print(str(node.val), end=" ")
        node = node.next
    print()


def removeNthFromEnd(head: ListNode, n: int) -> ListNode:
    # Two pointers - fast and slow
    slow = head
    fast = head
    # Move fast pointer n steps ahead
    for i in range(0, n):
        if fast.next is None:
            # If n is equal to the number of nodes, delete the head node
            if i == n - 1:
                head = head.next
            return head
        fast = fast.next
    # Loop until fast node reaches to the end
    # Now we will move both slow and fast pointers
    while fast.next is not None:
        slow = slow.next
        fast = fast.next
    # Delink the nth node from last
    if slow.next is not None:
        slow.next = slow.next.next
    return head


if __name__ == '__main__':
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)
    printList(removeNthFromEnd(head, 2))

    head = ListNode(1)
    printList(removeNthFromEnd(head, 1))

    head = ListNode(1)
    head.next = ListNode(2)
    printList(removeNthFromEnd(head, 1))
