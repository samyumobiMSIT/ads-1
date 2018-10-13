import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    /**
     * name of the stock.
     */
    private String ticker;
    /**
     * change in stock value.
     */
    private float change;
    /**
     * Constructs the object.
     *
     * @param      name     The name of the stock.
     * @param      percent  The percent change.
     */
    Stock(final String name, final float percent) {
        this.ticker = name;
        this.change = percent;
    }
    /**
     * Gets the name of the stock.
     *
     * @return     The name.
     */
    public String getName() {
        return this.ticker;
    }
    /**
     * Gets the change in stock value.
     *
     * @return     The change.
     */
    public float getChange() {
        return this.change;
    }
    /**
     * compares two objects.
     *
     * @param      other  The other
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stock other) {
        if (this.change > other.change) {
            return 1;
        }
        if (this.change < other.change) {
            return -1;
        }
        if (this.ticker.compareTo(other.ticker) > 0) {
            return 1;
        }
        if (this.ticker.compareTo(other.ticker) < 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.ticker + " " + this.change;
    }
}
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        final int six = 6;
        final int five = 5;
        int num = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < six; i++) {
            int count = 0;
            MinPQ<Stock> minpq = new MinPQ<>();
            MaxPQ<Stock> maxpq = new MaxPQ<>();
            while (count < num) {
                String[] tokens = scan.nextLine().split(",");
                Stock stock = new Stock(tokens[0], Float.parseFloat(tokens[1]));
                minpq.insert(stock);
                maxpq.insert(stock);
                count++;
            }
            BinarySearchTree<String, Float> stockbest =
            new  BinarySearchTree<>();
            BinarySearchTree<String, Float> stockworst
            = new BinarySearchTree<>();
            for (int j = 0; j < five; j++) {
                Stock maxpqbest = maxpq.delMax();
                System.out.println(maxpqbest);
                stockbest.put(maxpqbest.getName(), maxpqbest.getChange());
            }
            System.out.println();
            for (int k = 0; k < five; k++) {
                Stock minpqworst = minpq.delMin();
                System.out.println(minpqworst);
                stockworst.put(minpqworst.getName(), minpqworst.getChange());
            }
            System.out.println();
        }
        int query = Integer.parseInt(scan.nextLine());
        if (query <= 0) {
            return;
        }
        else {
            for (int i = 0; i < query; i ++) {
                String line = scan.nextLine();
                String[] qrs = line.split(",");
                System.out.println(Arrays.toString(qrs));
                String function = qrs[0];
                // String op = qrs[1];
                // String c_name = qrs[2];
                switch (function) {
                    case "get": 
                        System.out.println("get");
                                break;

                    case "intersection": System.out.println("Intersection");
                                         break;
                    default: break;
                }

            }
        }
    }
}