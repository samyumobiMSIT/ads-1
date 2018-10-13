class Heap<E extends Comparable<E>> {
     /**
     * Determines if heap.
     *  Best case: O(1)
     *  worst case :O(n)
     *  Average case: O(n)
     *
     * @param      a     { parameter_description }
     *
     * @return     True if heap, False otherwise.
     */
    public boolean isMinHeap(final E[] arr) {
        int index = arr.length - 1;
        while (index > 1) {
            if (arr[index].compareTo(arr[index / 2]) >= 0) {
                index = index - 1;
            } else {
                return false;
            }
        }
        return true;
    }
}