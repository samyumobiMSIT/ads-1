import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * Constructs the object.
	 */
	protected Solution() {

	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Scanner sc = new Scanner(System.in);	
		while (sc.hasNextLine()) {
			String[] tokens = sc.nextLine().split(",");
			switch (tokens[0]) {
				case "put":
					Book key = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
					int value = Integer.parseInt(tokens[4]);
					bst.put(key, value);
					break;
				case "get":
				    key = new Book(tokens[1], tokens[2], Float.parseFloat(tokens[3]));
					System.out.println(bst.get(key));
					break;
				default:
			}
		}
	}
}