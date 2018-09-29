class Stack {

    Node first = null;

    int size = 0;

    class Node {

        int data;

        Node next;

        Node(int data) {

            this.data = data;

        }

    }

    public boolean isEmpty() {

        return size == 0;

    }

    public void push(int ele) {

        Node newnode = new Node(ele);

        newnode.next = first;

        first = newnode;

        size++;

    }



    public int pop() {

        int item = first.data;

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

    }

}