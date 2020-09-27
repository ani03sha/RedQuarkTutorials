/**
 * @author Anirudh Sharma
 */

var addTwoNumbers = function (l1, l2) {
    // Head of the new linked list - this is the head of the resultant list
    let head = null;
    // Reference of head which is null at this point
    let temp = null;
    // Carry
    let carry = 0;
    // Loop for the two lists
    while (l1 !== null || l2 !== null) {
        // At the start of each iteration, we should add carry from the last iteration
        let sum = carry;
        // Since the lengths of the lists may be unequal, we are checking if the
        // current node is null for one of the lists
        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }
        // At this point, we will add the total sum % 10 to the new node
        // in the resultant list
        let node = new ListNode(Math.floor(sum) % 10);
        // Carry to be added in the next iteration
        carry = Math.floor(sum / 10);
        // If this is the first node or head
        if (temp == null) {
            temp = head = node;
        }
        // For any other node
        else {
            temp.next = node;
            temp = temp.next;
        }
    }
    // After the last iteration, we will check if there is carry left
    // If it's left then we will create a new node and add it
    if (carry > 0) {
        temp.next = new ListNode(carry);
    }
    return head;
};

class ListNode {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}


let head1 = new ListNode(2);
head1.next = new ListNode(4);
head1.next.next = new ListNode(3);

let head2 = new ListNode(5);
head2.next = new ListNode(6);
head2.next.next = new ListNode(4);

let result = addTwoNumbers(head1, head2);
let s = "";
while (result !== null) {
    s += result.val + " ";
    result = result.next;
}
console.log(s);
