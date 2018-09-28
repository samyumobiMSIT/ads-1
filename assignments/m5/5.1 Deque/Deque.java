public class Deque {

    public static class Item {
        String value;
        Item next;
        Item previous;
    }

    private int size = 0;
    private Item leftmost = null;
    private Item rightmost = null;

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public void pushLeft(Item item) {
        size++;

        if (leftmost != null) {
            item.next = leftmost;
            leftmost.previous = item;
        }

        leftmost = item;

    }

    public void pushRight(Item item) {
        size++;

        if (rightmost != null) {
            item.previous = rightmost;
        }

        rightmost = item;

    }

    public Item popLeft() {
        size--;

        Item popped = leftmost;

        leftmost = leftmost.next;

        return popped;
    }

    public Item popRight() {
        size--;

        Item popped = rightmost;

        rightmost = rightmost.previous;

        return popped;
    }

    public static void main(String[] args) {

        Deque testDeque = new Deque();
        if (testDeque.isEmpty() != true) throw new AssertionError();

        if (testDeque.size() != 0) throw new AssertionError();

        Item newItem = new Item();
        newItem.value = "1st item";
        testDeque.pushLeft(newItem);

        if (testDeque.isEmpty() != false) throw new AssertionError();
        if (testDeque.size() != 1) throw new AssertionError();

        Item anotherNewItem = new Item();
        anotherNewItem.value = "2nd item";
        testDeque.pushRight(anotherNewItem);

        if (testDeque.isEmpty() != false) throw new AssertionError();
        if (testDeque.size() != 2) throw new AssertionError();

        Item poppedLeft = testDeque.popLeft();
        if (testDeque.isEmpty() != false) throw new AssertionError();
        if (testDeque.size() != 1) throw new AssertionError();
        if (poppedLeft.value.equals("1st item") != true) throw new AssertionError();

        Item poppedRight = testDeque.popRight();
        if (testDeque.isEmpty() != true) throw new AssertionError();
        if (testDeque.size() != 0) throw new AssertionError();
        if (poppedRight.value.equals("2nd item") != true) throw new AssertionError();


    }

}