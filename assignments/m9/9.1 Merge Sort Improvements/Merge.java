class Merge {
    final int CUTOFF = 7;
    Merge() {
    	//unused.
    }
    /**
     * Time complexity is O(N).
     */
    public void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
        int i = low, j = mid+1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > high) {
                aux[k] = array[i++];
            } else if (less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
    }
    /**
     * Time complexity is O(1)
     */
    private void sort(Comparable[] array, Comparable[] aux, int low, int high) {
        if (high <= low + CUTOFF) {
            insertionSort(aux, low, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = low + (high - low) / 2;
        sort(aux, array, low, mid);
        sort(aux, array, mid + 1, high);

        if (!less(array[mid + 1], array[mid])) {
           for (int i = low; i <= high; i++) {
            aux[i] = array[i];
            }
            System.out.println("Array is already sorted. So, skipped the call to merge...");
           return;
        }
        merge(array, aux, low, mid, high);
    }
    /**
     * Time complexity is O(1)
     */
    public void sort(Comparable[] array) {
        Comparable[] aux = array.clone();
        sort(aux, array, 0, array.length-1);
    }
    /**
     * Time complexity is O(N^2)
     */
    public void insertionSort(Comparable[] array, int low, int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(array[j], array[j-1]); j--) {
                swap(array, j, j-1);
            }
        }
    }
    /**
     * Time complexity is O(1)
     */
    public void swap(Comparable[] array, int i, int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
    /**
     * Time complexity is O(1)
     */
    public boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * Time complexity is O(N)
     */
    public Object print(Object[] a) {
        String s = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            s += a[i] + ", ";
        }
        s = s + a[a.length - 1] + "]";
        return s;
    }
}