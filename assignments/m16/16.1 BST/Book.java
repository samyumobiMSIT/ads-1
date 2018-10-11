
/**
 * Class for book.
 */
class Book {
	/**
	 * name of the book.
	 */
	private String name;
	/**
	 * name of the author.
	 */
	private String author;
	/**
	 * price of the book.
	 */
	private float price;
	/**
	 * constructor 
	 *
	 * @param      n     { name }
	 * @param      a     { author }
	 * @param      p     { price }
	 */
	Book(String n, String a, float p) {
		this.name = n;
		this.author = a;
		this.price = p;
	}
	public String getName() {
		return this.name;
	}
}

