import java.util.Queue;
import java.util.LinkedList;
/**
 * Class for linear probing hash st.
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class LinearProbingHashST<Key, Value> {
    /**
     * initial capacity of type int.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * number of key-value pairs in the symbol table.
     */
    private int n;
    /**
     * size of linear probing table.
     */
    private int m;
    /**
     * the keys.
     */
    private Key[] keys;
    /**
     * the values.
     */
    private Value[] vals;
    /**
     * Initializes an empty symbol table.
     */
    public LinearProbingHashST() {
        this(INIT_CAPACITY);
    }
    /**
     * Initializes an empty symbol table
     *  with the specified initial capacity.
     * @param capacity the initial capacity
     */
    public LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }
    /**
     * checks whether the key is present in symbol table or not.
     * @param      key   The key
     * @return     true or false.
     * Time complexity for this method is O(1).
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }
    /**
     * keys method that adds the keys into the queue.
     * @return     queue of type Iterable.
     * Time complexity for this method is O(N).
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                queue.add(keys[i]);
            }
        }
        return queue;
    }
    /**
     * hash function for keys - returns value between 0 and M-1.
     * @param      key   The key
     * @return     hash value of type int.
     * Time complexity for this method is O(log N)*
     * (*) represents that in some cases the time complexity may be
     * O(N)
     */
    private int hash(final Key key) {
        final int eleven = 11;
        final int code = 0x7fffffff;
        return eleven * (key.hashCode() & code) % m;
    }
    /**
     * Inserts the key value pair to the symbol table.
     * @param      key   The key
     * @param      val   The value
     * Time complexity for this method is O(log N)*
     * (*) represents that in some cases the time complexity may be
     * O(N)
     */
    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        if (n >= m / 2) {
            resize(2 * m);
        }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }
    /**
     * Returns the value associated with the specified key.
     * @param      key   The key
     * @return     value of the specified key of type Value.
     * Time complexity for this method is O(log N)*
     * (*) represents that in some cases the time complexity may be
     * O(N)
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Student doesn't exists...");
        }
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }
    /**
     * deletes the specified key from the symbol table.
     * @param      key   The key
     * Time complexity for this method is O(log N)*
     * (*) represents that in some cases the time complexity may be
     * O(N)
     */
    public void delete(final Key key) {
        if (!contains(key)) {
            return;
        }
        // find position i of key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        // delete key and associated value
        keys[i] = null;
        vals[i] = null;
        // rehash all keys in same cluster
        i = (i + 1) % m;
        while (keys[i] != null) {
            // delete keys[i] an vals[i] and reinsert
            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }
        n--;
        final int eight = 8;
        if (n > 0 && n <= m / eight) {
            resize(m / 2);
        }
    }
    /**
    * if the array size fills by half the array gets resized.
    * doubled the size of the previous array.
    *Time complexity of the fucntion is N.
    * @param      capacity  The capacity
     * Time complexity for this method is O(N).
    */
    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp =
            new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m = temp.m;
    }
}