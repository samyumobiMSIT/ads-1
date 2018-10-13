import java.util.NoSuchElementException;
/**
BST Class
**/
 class BinarySearchST<Key extends Comparable<Key>, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int n = 0;

    /**
     * Initializes an empty symbol table.
     */
    public BinarySearchST() {
        this(INIT_CAPACITY);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     * @param capacity the maximum capacity
     */
    public BinarySearchST(int capacity) {
    	keys = (Key[]) new Comparable[capacity];
    	vals = (Value[]) new Object[capacity]; 
    }
     /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return n;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }


    /**
     * contains.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

     /**
     * gets function.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null"); 
        if (isEmpty()) return null;
        int i = rank(key); 
        if (i < n && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    } 

   /**
     * rank.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null"); 

        int lo = 0, hi = n-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            int cmp = key.compareTo(keys[mid]);
            if      (cmp < 0) hi = mid - 1; 
            else if (cmp > 0) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    } 
    

    /**
     * inserts a key-value pair.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     * @param      key    The key
     * @param      value  The value
     */
    public void put(Key key, Value val)  {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null"); 

        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        // key is already in table
        if (i < n && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        
        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = val;
        n++;

     } 

   /**
     * deletes.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     * @param      key   The key
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null"); 
        if (isEmpty()) return;

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            vals[j] = vals[j+1];
        }

        n--;
        keys[n] = null;  // to avoid loitering
        vals[n] = null;

        
    } 

    /**
     * deletes min value.
     * Best case: O(1)
     * Worst case: O(N)
     * Average case: O(N)
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow error");
        delete(keys[0]);
    }
    /**
     * max.
     * Best case: O(1)
     * Worst case: O(1)
     * Average case: O(1)
     * @return     { description_of_the_return_value }
     */
   
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("called max() with empty symbol table");
        return keys[n-1];
    }

    void keys() {
        for (int i = 0; i < n; i++) {
            if (vals[i] != null) {
                System.out.println(keys[i] + " " + vals[i]);
            }
        }
    }
  

     /**
     * floor.
     * Best case: O(1)
     * Worst case: O(logN)
     * Average case: O(logN)
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to floor() is null"); 
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
        if (i == 0) return null;
        else return keys[i-1];
    }
}

   
   
    


  