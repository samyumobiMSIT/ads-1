/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchTree<Key extends Comparable<Key>, Value> {
	BinarySearchTree() {

	}
	private Node root;
	private class Node {
		private Book key;
		private int value;
		private Node left, right;
		/**
		 * Constructs the object.
		 *
		 * @param      k     { book }
		 * @param      v     { value }
		 */
		Node(Book k, int v) {
			this.key = k;
			this.value = v;
		}
	}
	/**
	 * put method
	 *
	 * @param      key    The key
	 * @param      value  The value
	 * 
	 * Requires O(N) complexity
	 */
	public void put(Book key, int value) {
		 root = put(root, key, value);
	}
	/**
	 * put overloaded method
	 *
	 * @param      x      { Node }
	 * @param      key    The key
	 * @param      value  The value
	 *
	 * @return     { returns the node }
	 */
	private Node put(Node x, Book key, int value) {
		if (x == null) {
			return new Node(key, value);
		}
		int cmp = key.getName().compareTo(x.key.getName());
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		}
		if (cmp > 0) {
			x.right = put(x.right, key, value);
		}
		if (cmp == 0) {
			x.value = value;
		}
		return x;
	}
	/**
	 * get method.
	 *
	 * @param      key   The key
	 *
	 * @return     { returns integer value }
	 *
	 * Complexity BST get(): O(N) 
	 */
	public Integer get(Book key) {
		Node x = root;
		while (x != null) {
			int cmp = key.getName().compareTo(x.key.getName());
				if (cmp < 0) {
					x = x.left;
				}
				if (cmp > 0) {
					x = x.right;
				} 
				if (cmp == 0) {
					return x.value;
				}
			}
			return null;
		}
	}