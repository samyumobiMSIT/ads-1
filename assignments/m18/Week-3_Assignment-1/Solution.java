import java.util.Scanner;
class Stock implements Comparable<Stock> {
	private String stockname;
	private float stockchange;
	Stock(String name, float change) {
		this.stockname = name;
		this.stockchange = change;
	}
	public String getstockname() {
		return this.stockname;
	}
	public float getstockchange() {
		return this.stockchange;
	}
	public int compareTo(Stock other) {
		if (this.stockchange > other.stockchange) {
			return 1;
		}
		if (this.stockchange < other.stockchange) {
			return -1;
		}
		if (this.stockname.compareTo(other.stockname) > 0) {
			return 1;
		}
		if (this.stockname.compareTo(other.stockname) < 0) {
			return -1;
		}
		return 0;
	}
	public String toString() {
		String str = "";
		str = str + this.stockname + this.stockchange;
		return str;
	}
}
class Solution {
	private Solution() {
		//unused.
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int stocknum = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < 6; i++) {
			int count = 0;
			MinPQ<Stock> minpqobj = new MinPQ<>();
			MaxPQ<Stock> maxpqobj = new MaxPQ<>();
			while (count < stocknum) {
				String[] details = scan.nextLine().split(",");
				Stock stockobj = new Stock(details[0], Float.parseFloat(details[1]));
				minpqobj.insert(stockobj);
				maxpqobj.insert(stockobj);
				count++;
			}
			

			BinarySearchTree<String, Float> stockbest = new  BinarySearchTree<>();
			BinarySearchTree<String, Float> stockworst = new BinarySearchTree<>();
			for (int j = 0; j < 5; j++) {
				Stock maxpqbest = maxpqobj.delMax();
				System.out.println(maxpqbest + "maxpqval");
				stockbest.put(maxpqbest.getstockname(), maxpqbest.getstockchange());
				Stock minpqworst = minpqobj.delMin();
				System.out.println(minpqworst + "minpqbest");
				stockworst.put(minpqworst.getstockname(), minpqworst.getstockchange());
			}
			
		}
	}
}