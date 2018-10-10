import java.util.Scanner;

public final class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        MaxPQ<Float> maxPQ = new MaxPQ<Float>(N);
        MinPQ<Float> minPQ = new MinPQ<Float>(N);
        float median = 0.0f;
        for (int i = 0; i < N; i++) {
            float value = scan.nextFloat();
            if (value > median) {
                minPQ.insert(value);
            } else {
                maxPQ.insert(value);
            }

            if (maxPQ.size() - minPQ.size() > 1) {
                minPQ.insert(maxPQ.delMax());
            }

            if (minPQ.size() - maxPQ.size() > 1) {
                
                maxPQ.insert(minPQ.delMin());
            }

            if (maxPQ.size() == minPQ.size()) {
                median = (maxPQ.peek() + minPQ.peek()) / 2;
               
            } else if (maxPQ.size() > minPQ.size()) {
                median = maxPQ.peek();
            } else {
                median = minPQ.peek();
            }
            
            System.out.println(median);
        }
    }
}