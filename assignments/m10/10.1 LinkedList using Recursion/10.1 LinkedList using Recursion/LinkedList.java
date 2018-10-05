/**
 * class for LinkedList.
 */
class LinkedList {
    /**
     * head of the linked list.
     */
    private Node head;
    /**
     * tail of the linked list.
     */
    private Node tail;
    /**
     * size of the linked list.
     */
    private int size;
    /**
     * index of the linked list.
     */
    private static int index;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * data inside the linked list link.
         */
        private int value;
        /**
         * pointer to next link in the linked list.
         */
        private Node next;
    }
    /**
     * Constructs the object.
     */
    LinkedList() {
        head = null;
        tail = null;
    }
    /**
     * inserts data at the begnining of the linked list.
     *
     * @param      value  The data to be inserted.
     */
    public void insertFront(final int value) {
        if (head == null) {
            Node oldHead = head;
            head = new Node();
            head.value = value;
            head.next = null;
            tail = head;
        } else {
            Node oldHead = head;
            head = new Node();
            head.value = value;
            head.next = oldHead;
        }
        size++;
    }
    /**
     * insert data at the end of the linked list.
     *
     * @param      value  The data to be inserted.
     */
    public void insertBack(final int value) {
        if (tail == null) {
            Node oldTail = tail;
           tail = new Node();
           tail.value = value;
           tail.next = null;
           head = tail;
        } else {
           Node oldTail = tail;
           tail = new Node();
           tail.value = value;
           tail.next = null;
           oldTail.next = tail;
        }
        size++;
    }
    /**
     * Removes element from the front of the linked list.
     */
    public void removeFront() {
        if (head != null) {
            head = head.next;
            size--;
        }
    }
    /**
     * Remove element from the end of the linked list.
     */
    public void removeBack() {
        if (tail != null) {
            Node temp = null;
            Node pop = tail;
            Node head1 = head;
            while (head1 != tail) {
                temp = head1;
                head1 = head1.next;
            }
            tail = temp;
            tail.next = null;
            size--;
        }
    }
    /**
     * insert data at paticular position.
     *
     * @param      position  The position
     * @param      value     The value
     */
    public void insertAt(final int position, final int value) {
        insertAt(head, position, value);
    }
    /**
     * insert data at paticular position.
     * Best Case Complexity - omega(1).
     * Average and Worst Case Complexity - O(N) and thetha(N).
     * @param      headptr      The head
     * @param      position  The position
     * @param      value     The value
     */
    public void insertAt(final Node headptr,
        final int position, final int value) {
        if (position == 0) {
            insertFront(value);
            return;
        }
        if (index + 1 == position) {
            Node newnode = new Node();
            newnode.value = value;
            newnode.next = headptr.next;
            headptr.next = newnode;
            index = 0;
            return;
        }
        index++;
        insertAt(headptr.next, position, value);
    }
    /**
     * reverses the linked list.
     */
    public void reverse() {
        head = reverseRecursive(head);
    }
    /**
     * recursively reverses the linked list.
     * Time Complexity - O(N).
     *
     * @param      head  The head
     *
     * @return     { returns the node }
     */
    public Node reverseRecursive(final Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    /**
     * returns size of the linked list.
     *
     * @return     { size of the linked list }
     */
    public int size() {
        return size;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size != 0) {
            String str = "";
            Node temp = head;
            while (temp != null) {
                str += temp.value + ", ";
                temp = temp.next;
            }
            return str.substring(0, str.length() - 2);
        }
        return "";
    }
}