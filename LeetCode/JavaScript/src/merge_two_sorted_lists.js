var mergeTwoLists = function (l1, l2) {
    // Check if either of the lists is null 
    if (!l1) {
        return l2;
    }
    if (!l2) {
        return l1;
    }
    // Head of the new linked list - this is the head of the resultant list
    let head = null;
    // Reference of head which is null at this point
    let temp;
    // Choose head which is smaller of the two lists
    if (l1.val < l2.val) {
        temp = head = new ListNode(l1.val);
        l1 = l1.next;
    } else {
        temp = head = new ListNode(l2.val);
        l2 = l2.next;
    }
    // Loop until any of the list becomes null
    while (l1 && l2) {
        if (l1.val < l2.val) {
            temp.next = new ListNode(l1.val);
            l1 = l1.next;
            temp = temp.next;
        } else {
            temp.next = new ListNode(l2.val);
            l2 = l2.next;
            temp = temp.next;
        }
    }
    // Add all the nodes in l1, if remaining
    while (l1) {
        temp.next = new ListNode(l1.val);
        l1 = l1.next;
        temp = temp.next;
    }
    // Add all the nodes in l2, if remaining
    while (l2) {
        temp.next = new ListNode(l2.val);
        l2 = l2.next;
        temp = temp.next;
    }
    return head;
};

function printList(node) {
    let list = [];
    while (node != null) {
        list.push(node.val);
        node = node.next
    }
    console.log(list.join(" "));
}

function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)
}

let head1 = new ListNode(1);
head1.next = new ListNode(2);
head1.next.next = new ListNode(4);
let head2 = new ListNode(1);
head2.next = new ListNode(3);
head2.next.next = new ListNode(4);
printList(mergeTwoLists(head1, head2));

printList(mergeTwoLists(null, null));

head2 = new ListNode(1);
printList(mergeTwoLists(null, head2));