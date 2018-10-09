import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;
/** - We use 2 Heaps to keep track of median
- We make sure that 1 of the following conditions is always true:
1) maxHeap.size() == minHeap.size()
 2) maxHeap.size() - 1 = minHeap.size()
**/
public class Solution {
    /** maxHeap: 
    keeps track of the LARGE numbers **/
    private static PriorityQueue<Integer> maxHeap = new 
    PriorityQueue<>(Collections.reverseOrder()); 
    /** minHeap : keeps track of the SMALL numbers **/
    private static PriorityQueue<Integer> minHeap = new 
    PriorityQueue<>();                         
    
    /**main Function **/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();
        medianTracker(array);
    }
    /** Computes the median and print median after 
    adding elements to maxHeap & minHeap **/
    public static void medianTracker(int [] array) {
        for (int i = 0; i < array.length; i++) {
            addNumber(array[i]);
            System.out.println(getMedian());
        }
    }
    
    /** Adds a number into the data structure to balance minHeap and maxHeap
    If size of max heap is 2 more than min heap, extract maximum element from max heap and put it in min heap.
    If size of min heap is 2 more than max heap, extract minimum element from min heap and put it in max heap.
    **/
    private static void addNumber(final int n) {
        if (maxHeap.isEmpty()) {
            //if empty add numbers to maxHeap
            maxHeap.add(n);
        } else if (maxHeap.size() == minHeap.size()) {
            //if size of min Heap and maxHeap are same
            if (n < minHeap.peek()) {
                 //length of array > no of min elements in minHeap
                maxHeap.add(n);
            } else {
                /** add elements to minHeap, then remove 
                from minHeap and insert into maxHeap **/
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (n > maxHeap.peek()) {
                //length of maxHeap > no of max elements in minHeap
                minHeap.add(n);
            } else {
                /** add elements to maxHeap, then remove 
                from maxHeap and insert into minHeap **/
                maxHeap.add(n); 
                minHeap.add(maxHeap.remove());
            }
        }
        // maxHeap will never have fewer elements than minHeap
    }
    /**Returns the median of current data stream
    median = (maxHeap elements + minHeap elements)  / 2**/
    private static double getMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else { // maxHeap must have more elements than minHeap
            return maxHeap.peek();
        }
    }
}
