import java.util.Scanner;

/**
 * MaxPQ, the elements are arranged based min heap.
 * @author Siva Sankar.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    /**
     * holds the keys in the pq array.
     */
    private Key[] pq;
    /**
     * indicates the numebr of elements in the array.
     */
    private int N;

    /**
     * default constructor.
     */
    public MaxPQ() {

    }

    /**
     * array is assigned to pq.
     * @param  MaxPQ the array.
     */
    public MaxPQ(final Key[] MaxPQ) {
        this.pq = MaxPQ;
        N = MaxPQ.length-1;
    }

    /**
     * Constructs the object based on capacity.
     * @param  capacity size of the initial pq.
     */
    public MaxPQ(final int capacity) {
        pq = (Key[]) new Comparable[capacity + 1];
    }

    /**
     * Inserts into the PQ.
     * @param key to be inserted.
     */
    public void insert(final Key key) {
        pq[++N] = key;
        swim(N);
    }

    /**
     * Deletes the minimum element.
     * @return the key that is deleted.
     */
    public Key delMax() {
        Key key = pq[1];
        exch (1, N--);
        sink(1);
        return key;
    }

    /**
     * Finds the min value in the PQ.
     * @return the minimum from the PQ.
     */
    public Key min() {
        return pq[1];
    }

    /**
     * finds the number of elements in the PQ.
     * @return the numebr of elements.
     */
    public int size() {
        return N;
    }

    /**
     * Checks whether the pq is empty or not.
     * @return true if pq is empty otherwise false.
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * sink through the pq.
     * @param k index.
     */
    public void sink(int k) {
        while ((2 * k) <= N) {
            int j = 2 * k;
            if (j < N && less(j+1, j)) {
                j++;
            }
            if (less(k, j)) {
                break;
            }
            exch (k, j);
            k = j;
        }
    }

    /**
     * swim through the PQ.
     * @param k index.
     */
    public void swim(int k) {
        while (k > 1 && less(k, k/2)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    /**
     * Gets the root element.
     * @return the root element.
     */
    public Key peek() {
        if (size() >= 1)
            return pq[1];
        else
            return null;
    }

    /**
     * Compares two objects.
     * @param  i index.
     * @param  j index.
     * @return true if value at i less than value at j, otherwise false.
     */
    public boolean less(final int i, final int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    /**
     * Exchanges the values at i and j positions.
     * @param i index.
     * @param j index.
     */
    public void exch(final int i, final int j) {
        Key k = pq[i];
        pq[i] = pq[j];
        pq[j] = k;
    }

    /**
     * String verions of the object.
     * @return String object.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < N; i++) {
            sb.append(pq[i] + ", ");
        }
        sb.append(pq[N]);
        return sb.toString();
    }

    /**
     * takes k as a parameter.
     * @param  k index.
     * @return true if the left and right children are well compared with
     * the root, otherwise false.
     */
    public boolean isMaxPQ(int k) {
        if (k > N) {
            return true;
        }
        int left = 2*k;
        int right = 2*k + 1;
        if (left <= N && !less(k, left)) {
            return false;
        }
        if (right <= N && !less(k, right)) {
            return false;
        }
        return isMaxPQ(left) && isMaxPQ(right);
    }

    /**
     * Finding whether the pq is MaxPQ or not.
     * @return true if the pq is in MaxPQ otherwise false.
     */
    public boolean isMaxPQ() {
        return isMaxPQ(1);
    }

    /**
     * demonstrate MaxPQ.
     * @param args command line args.
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        // Integer[] ints = {0, -1, 2, 13, 11, 4, 15, 14};
        MaxPQ<Integer> MaxPQ = new MaxPQ(N);
        while(scan.hasNext()) {
         MaxPQ.insert(scan.nextInt());
         System.out.println(MaxPQ);
        }
        while (MaxPQ.size() > 1) {
            MaxPQ.delMax();
            System.out.println(MaxPQ);
        }
        System.out.println(MaxPQ);
        System.out.println(MaxPQ.isMaxPQ());
    }
}