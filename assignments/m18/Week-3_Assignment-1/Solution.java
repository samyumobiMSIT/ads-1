import java.util.Scanner;
class Stock implements Comparable <Stock> {
	private String ticker;
	private float change;
	Stock(final String name, final float percent) {
		this.ticker = name;
		this.change = percent;
	}
	public String getName() {
		return this.ticker;
	}
	public float getChange() {
		return this.change;
	}
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
			for(int k = 0; k < five; k++) {
				Stock minpqworst = minpq.delMin();
				System.out.println(minpqworst);
				stockworst.put(minpqworst.getName(), minpqworst.getChange());
			}
			System.out.println();
		}
	}
}