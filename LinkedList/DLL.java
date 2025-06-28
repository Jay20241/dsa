
public class DLL {

    private Node head;

    //===============================================
    //                   Find 
    //===============================================

    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    //===============================================
    //                   Insert 
    //===============================================
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node; //change head location
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node temp = head;

        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        node.prev = temp;
    }

    public void insert(int after, int val) { //Insert after the provided value
        Node p = find(after); //after is value, not index.

        if (p == null) {
            System.out.println("does not exist");
            return;
        }

        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) { //possible that node can be last element
            node.next.prev = node;
        }
    }

    //===============================================
    //                   Display 
    //===============================================
    public void display() {
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");

        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("START");
    }

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}