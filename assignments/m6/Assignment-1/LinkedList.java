
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

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

public class ListIterator<Item> implements Iterator<Item> {

		private Node<Item> current;



		public ListIterator(Node<Item> first) {

			current = first;

		}



		public boolean hasNext() {

			return current != null;

		}



		public Item next() {

			Item item = (Item) current.item;

			current = current.next;

			return item;

		}



		public void remove() { }

	}



	public void insert(Item item) {

		Node<Item> temp = new Node<Item>();

		temp.item = item;

		temp.next = null;



		if (first == null) {

			first = temp;

			last = temp;

		} else {

			last.next = temp;

			last = temp;

		}

	}



	public String toString() {

		StringBuffer sb = new StringBuffer();

		Iterator<Item> iter = this.iterator();

		while(iter.hasNext()) {

			sb.append(iter.next());

		}

		return sb.toString();

	}

}
