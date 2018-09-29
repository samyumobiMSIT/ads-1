import java.util.*;



public class Stack<E> implements Iterable<E> {



	private static class Node<E> {

		private E data;

		private Node<E> next;

	}



	private Node<E> first;



	public Iterator<E> iterator() {

		return new ListIterator<E>();

	}



	private class ListIterator<E> implements Iterator<E> {

		private Node current = first;



		public boolean hasNext() {

			return current != null;

		}



		public E next() {

			E item = (E) current.data;

			current = current.next;

			return item;

		}



		public void remove() { }



	}





	public String toString() {

		StringBuffer sb = new StringBuffer();

		Iterator<E> iter = this.iterator();



		while(iter.hasNext()) {

			sb.append(iter.next() + ", ");

		}

		return sb.toString();

	}





	public boolean isEmpty() {

		return first == null;

	}



	public void push(E item) throws Exception {

		Node<E> temp = new Node<E>();

		if (temp == null) {

			throw new Exception("Stack is full");

		}

		temp.data = item;

		temp.next = first;

		first = temp;

	}	



	// public String toString() {

	// 	StringBuffer sb = new StringBuffer();

	// 	if (first == null) {

	// 		throw new NoSuchElementException("Stack is empty");

	// 	}



	// 	Node<E> temp = first;

	// 	while(temp.next != null) {

	// 		sb.append(temp.data + ", ");

	// 		temp = temp.next;

	// 	}

	// 	sb.append(temp.data);

	// 	return sb.toString();

	// }



	public E peek() {

		if (first == null)

			throw new NoSuchElementException("Stack is empty");

		return first.data;

	}



	public E pop() {

		if (first == null)

			throw new NoSuchElementException("Stack is empty");

		E data = first.data;

		first = first.next;

		return data;

	}



	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();

		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {

			String[] words = scan.nextLine().split(" ");

			switch(words[0]) {

				case "push":

				try {

					stack.push(words[1]);

				} catch (Exception ex) {

					System.out.println(ex.getMessage());

				}

				break;

				case "pop":

				try {

					String data = stack.pop();

					// System.out.println(data);

				} catch (Exception ex) {

					System.out.println(ex.getMessage());

				}

				break;

				case "display":

				System.out.println(stack);

				default:

				break;

			}

		}

	}

}