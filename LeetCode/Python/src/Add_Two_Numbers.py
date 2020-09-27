"""
@author - Anirudh Sharma
"""


class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


def addTwoNumbers(l1: ListNode, l2: ListNode) -> ListNode:
    # Head of the new linked list - this is the head of the resultant list
    head = None
    # Reference of head which is null at this point
    temp = None
    # Carry
    carry = 0
    # Loop for the two lists
    while l1 is not None or l2 is not None:
        # At the start of each iteration, we should add carry from the last iteration
        sum_value = carry
        # Since the lengths of the lists may be unequal, we are checking if the
        # current node is null for one of the lists
        if l1 is not None:
            sum_value += l1.val
            l1 = l1.next
        if l2 is not None:
            sum_value += l2.val
            l2 = l2.next
        # At this point, we will add the total sum_value % 10 to the new node
        # in the resultant list
        node = ListNode(sum_value % 10)
        # Carry to be added in the next iteration
        carry = sum_value // 10
        # If this is the first node or head
        if temp is None:
            temp = head = node
        # for any other node
        else:
            temp.next = node
            temp = temp.next
    # After the last iteration, we will check if there is carry left
    # If it's left then we will create a new node and add it
    if carry > 0:
        temp.next = ListNode(carry)
    return head


head1 = ListNode(2)
head1.next = ListNode(4)
head1.next.next = ListNode(3)

head2 = ListNode(5)
head2.next = ListNode(6)
head2.next.next = ListNode(4)

result = addTwoNumbers(head1, head2)
while result is not None:
    print(str(result.val), end=" ")
    result = result.next
