import java.util.Comparator;
/**
 * Class for minimum pq.
 * @param      <Key>  The key
 */
public class MinPQ<Key> {
    /**
     * pq array of type Key.
     */
    private Key[] pq;
    /**
     * size of array pq.
     */
    private int n;
    /**
     * comparator of type Comparator.
     */
    private Comparator<Key> comparator;
    /**
     * Initializes an empty priority queue with the given initial capacity.
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
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     * @param  initCapacity the initial capacity of this priority queue
     * @param  comparator the order in which to compare the keys
     */
    public MinPQ(final int initCapacity, final Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }
    /**
     * Initializes an empty priority queue using the given comparator.
     * @param  comparator the order in which to compare the keys
     */
    public MinPQ(final Comparator<Key> comparator) {
        this(1, comparator);
    }
    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys, using sink-based heap construction.
     * @param  keys the array of keys
     */
    public MinPQ(final Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i + 1] = keys[i];
        for (int k = n / 2; k >= 1; k--)
            sink(k);
    }
    /**
     * Returns true if this priority queue is empty.
     * @return {@code true} if this priority queue is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }
    /**
     * Returns the number of keys on this priority queue.
     * @return the number of keys on this priority queue
     */
    public int size() {
        return n;
    }
    /**
     * Returns a smallest key on this priority queue.
     * @return a smallest key on this priority queue.
     */
    public Key min() {
        if (isEmpty()) {
            return null;
        }
        return pq[1];
    }
    /**
     * resize method to resize the array.
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**
     * Adds a new key to this priority queue.
     * @param  x the key to add to this priority queue
     */
    public void insert(final Key x) {
        if (n == pq.length - 1) resize(2 * pq.length);
        pq[++n] = x;
        swim(n);
    }
    /**
     * Removes and returns a smallest key on this priority queue.
     * @return a smallest key on this priority queue
     */
    public Key delMin() {
        if (isEmpty()) {
            return null;
        }
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        return min;
    }
    /**
     * swim method.
     * @param      k    index.
     */
    private void swim(final int k) {
    	int k1 = k;
        while (k1 > 1 && greater(k1 / 2, k1)) {
            exch(k1, k1 / 2);
            k1 = k1 / 2;
        }
    }
    /**
     * sink method.
     * @param      k    index.
     */
    private void sink(final int k) {
    	int k1 = k;
        while (2 * k1 <= n) {
            int j = 2 * k1;
            if (j < n && greater(j, j + 1)) j++;
            if (!greater(k1, j)) break;
            exch(k1, j);
            k1 = j;
        }
    }
    /**
     * greater method.
     * @param      i     index.
     * @param      j     index.
     * @return     true or false.
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }
    /**
     * exch method to swap the elements.
     * @param      i     index.
     * @param      j     index.
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
    /**
     * Determines if minimum heap.
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap() {
        return isMinHeap(1);
    }
    /**
     * Determines if minimum heap.
     * @param      k     index.
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap(final int k) {
        if (k > n) return true;
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }
}