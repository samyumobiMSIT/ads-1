import java.util.Comparator;
import java.util.ArrayList;
/**
 * Class for minimum pq.
 *
 * @param      <Key>  The key
 */
public class MinPQ<Key> {
    /**
     * stores items from 1 to n.
     */
    private Key[] pq;
    /**
     * Number of items on priority queue.
     */
    private int n;
    /**
     * Comparator variable.
     */
    private Comparator<Key> comparator;

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param  initCapacity the initial capacity of this priority queue
     */
    public MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MinPQ() {
        this(1);
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     *
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }

    /**
     * Returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     */
    public Key min() {
        return pq[1];
    }
    /**
     * Resizing function.
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * Adds a new key to this priority queue.
     *
     * @param  x the key to add to this priority queue
     */
    public void insert(final Key x) {
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        pq[++n] = x;
        swim(n);
    }

    /**
     * Removes and returns a smallest key on this priority queue.
     *
     * @return a smallest key on this priority queue
     */
    public Key delMin() {
        //no of hours is 6
        // top5 bestP,worstP array is n-1 so taking 4
        final int four = 4;
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / four)) {
            resize(pq.length / 2);
        }
        return min;
    }
    /**
    * Swim function.
    *
    * @param      k1     { parameter_description }
    */
    private void swim(final int k1) {
        int k = k1;
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }
    /**
     * Sink function.
     *
     * @param      k1     { parameter_description }
     */
    private void sink(final int k1) {
        int k = k1;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    /**
     * Checks if greater.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * Exchange function.
     *
     * @param      i     { parameter_description }
     * @param      j1     { parameter_description }
     */
    private void exch(final int i, final int j1) {
        int j = j1;
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /**
     * Prints the minimum 5 of the PQ.
     *
     * @param      worst  The worst
     */
    public void print5(final ArrayList<Key> worst) {
        final int five = 5;
        for (int i = 1; i <= five; i++) {
            Key temp = delMin();
            System.out.println(temp);
            worst.add(temp);
        }
        System.out.print("\n");
    }
}