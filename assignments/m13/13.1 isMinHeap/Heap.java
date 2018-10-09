class Heap<E extends Comparable<E>> {
    /**
     * Determines if minimum heap.
     * { time complexity to check whther it is minheap or not is O(n) }
     * @param      arr   The arr
     *
     * @return     True if minimum heap, False otherwise.
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