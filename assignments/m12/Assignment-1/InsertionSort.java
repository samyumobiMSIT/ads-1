/** Insertion Sort Algorithm 
    to sort elements with complexity O(nLogN)
    **/
    public class InsertionSort {
    /** exchange method to iterate
    through list and swap smallest element lo
    to largest element hi **/
    void exchange(final Student[] list, final int lo, final int hi) {
        Student temp = list[lo];
        list[lo] = list[hi];
        list[hi] = temp;
    }
    /**less method to compare
    Student records **/
    boolean less(final Student one, Student two) {
        return one.compareTo(two) == -1;
    }
    /** sort Student records by iterating throught record
    check if less - true swap else go to next element 
    (n-1) exchanges, n comparisons for every record **/
    void sort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(students[j - 1], students[j])) {
                    exchange(students, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
}