var removeNthFromEnd = function (head, n) {
    // Two pointers - fast and slow
    let slow = head;
    let fast = head;
    // Move fast pointer n steps ahead
    for (let i = 0; i < n; i++) {
        if (fast.next === null) {
            // If n is equal to the number of nodes, delete the head node
            if (i === n - 1) {
                head = head.next;
            }
            return head;
        }
        fast = fast.next;
    }
    // Loop until we reach to the end.
    // Now we will move both fast and slow pointers
    while (fast.next !== null) {
        slow = slow.next;
        fast = fast.next;
    }
    // Delink the nth node from last
    if (slow.next !== null) {
        slow.next = slow.next.next;
    }
    return head;
};

function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}

function printList(node) {
    let list = [];
    while (node != null) {
        list.push(node.val);
        node = node.next
    }
    console.log(list.join(" "));
}

head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
head.next.next.next = new ListNode(4);
head.next.next.next.next = new ListNode(5);
printList(removeNthFromEnd(head, 2));

head = new ListNode(1);
printList(removeNthFromEnd(head, 1));

head = new ListNode(1);
head.next = new ListNode(2);
printList(removeNthFromEnd(head, 1));

