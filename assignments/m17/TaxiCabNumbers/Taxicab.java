import java.util.PriorityQueue;
 
public class Taxicab implements Comparable<Taxicab> {
 
  private final long sum;
  private final int i;
  private final int j;
 
  // create a new tuple (i, j, i^3 + j^3)
  public Taxicab(int i, int j) {
    this.sum = (long) i * i * i + (long) j * j * j;
    this.i = i;
    this.j = j;
  }
 
  public int compareTo(Taxicab that) {
    if (this.sum < that.sum) {
      return -1;
    } else if (this.sum > that.sum) {
      return +1;
    } else {
      return 0;
    }
  }
 
  public String toString() {
    return i + "^3 + " + j + "^3";
  }
 
  public static void main(String[] args) {
 
    int N = Integer.parseInt(args[0]);
 
    // initialize priority queue
    PriorityQueue<Taxicab> pq = new PriorityQueue<Taxicab>();
    for (int i = 1; i <= N; i++) {
      pq.add(new Taxicab(i, i));
    }
 
    // enumerate sums in ascending order, look for repeated sums
    int run = 1;
    Taxicab prev = new Taxicab(0, 0);   // sentinel
    while (!pq.isEmpty()) {
      Taxicab s = pq.poll();
 
      // sum is same as previous one
      if (prev.sum == s.sum) {
        run++;
        if (run == 2) {
          System.out.print(prev.sum + " = " + prev);
        }
        System.out.print(" = " + s);
      } else {
        if (run > 1) {
          System.out.println();
        }
        run = 1;
      }
      prev = s;
 
      if (s.j < N) {
        pq.add(new Taxicab(s.i, s.j + 1));
      }
    }
    if (run > 1) {
      System.out.println();
    }
  }
 
}