import java.util.Scanner;
import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
    /**
     * { var_description }.
     */
    Key[] keys;
    /**
     * { var_description }.
     */
    Value[] values;
    /**
     * { var_description }.
     */
    int size;
    /**
     * Constructs the object.
     *
     * @param      length  The length
     */
    BinarySearchTree() {
        keys = (Key[])new Comparable[30];
        values = (Value[]) new Object[30];
        size = 0;
    }
    /**
     * { function_description }.
     *
     * @param      keyval  The keyval
     *
     * @return     { description_of_the_return_value }
     */
    int rank(Key keyval) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int compare = keyval.compareTo(keys[mid]);
            if (compare < 0) {
                high = mid - 1;
            } else if (compare > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }
    /**
     * { function_description }.
     *
     * @param      keyval  The keyval
     *
     * @return     { description_of_the_return_value }
     */
    Value get(Key keyval) {
        if (!contains(keyval)) {
            return null;
        }
        int rankval = rank(keyval);
        return values[rankval];
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return size == 0;
    }
    /**
     * { function_description }.
     *
     * @param      keyval  The keyval
     *
     * @return     { description_of_the_return_value }
     */
    boolean contains(Key keyval) {
        int rankval = rank(keyval);
        return keyval.compareTo(keys[rankval]) == 0;
    }
    /**
     * { function_description }.
     *
     * @param      keyval  The keyval
     * @param      val     The value
     */
    void put(Key keyval, Value val) {
        int rankval = rank(keyval);
        if (size > 0 && rankval < size && keys[rankval].compareTo(keyval) == 0) {
            values[rankval] = val;
            return;
        }
        for (int i = size; i > rankval; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[rankval] = keyval;
        values[rankval] = val;
        size++;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    Key max() {
        return keys[size - 1];
    }
    /**
     * { function_description }.
     */
    void deleteMin() {
        for (int i = 0; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        size--;
    }
    /**
     * { function_description }.
     *
     * @param      keyval  The keyval
     *
     * @return     { description_of_the_return_value }
     */
    Key floor(Key keyval) {
        int rankval = rank(keyval);
        if (rankval < size && contains(keyval)) {
            return keyval;
        }
        if (rankval == 0) {
            return null;
        }
        return keys[rankval - 1];
    }
    /**
     * { function_description }.
     */
    void print() {
        Key[] keysnew = Arrays.copyOf(keys, size);
        MyIterable<Key> mylist = new MyIterable<>(keysnew);
        for(Key eachkey: mylist) {
            System.out.println(eachkey + " "+ get(eachkey));
        }
    }
}
class MyIterable<Key> implements Iterable<Key> {
    /**
     * { var_description }.
     */
    private List<Key> list;
    /**
     * Constructs the object.
     *
     * @param      k     { parameter_description }
     */
    public MyIterable(Key[] k) {
        list = Arrays.asList(k);
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public Iterator<Key> iterator() {
        return list.iterator();
    }
}