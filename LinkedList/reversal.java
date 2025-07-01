// recursion reverse
private void reverse(Node node) {
    if (node == tail) {
        head = tail;
        return;
    }
    reverse(node.next);
    tail.next = node;
    tail = node;
    tail.next = null;
}


// in place reversal of linked list
// google, microsoft, apple, amazon: https://leetcode.com/problems/reverse-linked-list/
public void reverse() {
    if (size < 2) {
        return;
    }

    Node prev = null;
    Node present = head;
    Node next = present.next;

    while (present != null) {
        present.next = prev;
        prev = present;
        present = next;
        if (next != null) {
            next = next.next;
        }
    }
    head = prev;
}