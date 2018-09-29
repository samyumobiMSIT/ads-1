public class LinkedList<Item> implements Iterable<Item> {



	private class Node<Item> {

		Item item;

		Node<Item> next;

	}



	private Node<Item> first;

	private Node<Item> last;



	public Iterator<Item> iterator() {

		return new ListIterator(this.first);

	}

