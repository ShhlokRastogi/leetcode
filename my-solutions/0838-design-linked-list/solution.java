class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    Node head;
    int size;
    public MyLinkedList() {
        head = null;
        size = 0;
    }
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node temp = head;
        int k = 0;
        while (k != index) {
            temp = temp.next;
            k++;
        }
        return temp.val;
    }
    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
    }
    public void addAtTail(int val) {
        Node temp = new Node(val);
        if (head == null) {
            head = temp;
            size++;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = temp;
        size++;
    }
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == size) {
            addAtTail(val);
            return;
        }
        Node temp = new Node(val);
        Node p = head;
        int c = 0;
        while (c != index - 1) {
            p = p.next;
            c++;
        }
        temp.next = p.next;
        p.next = temp;
        size++;
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node p = head;
        int c = 0;
        while (c != index - 1) {
            p = p.next;
            c++;
        }
        Node k = p.next;
        p.next = k.next;
        k.next = null;
        size--;
    }
}
