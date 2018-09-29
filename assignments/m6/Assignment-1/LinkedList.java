class LinkedList {

    Node first = null;

    Node last = null;

    int size = 0;

    class Node {

        String data;

        Node next;

        Node(String data) {

            this.data = data;

        }

    }

    public boolean isEmpty() {

        return size == 0;

    }

    public void push(String element) {

        Node newnode = new Node(element);

        if (isEmpty()) {

            first = newnode;

            last = first;

            last.next = null;

            size++;

            return;

        }

        Node oldlast = last;

        last = newnode;

        oldlast.next = last;

        last.next = null;

        size++;



    }

    public String pop() {

        if (isEmpty()) {

            return null;

        }

        String item = first.data;

        first = first.next;

        size--;

        return item;



    }

    public void printList() {

        Node tnode = first;

        while (tnode != null) {

            System.out.print(tnode.data + " ");

            tnode = tnode.next;

        }

        System.out.println();



    }

}