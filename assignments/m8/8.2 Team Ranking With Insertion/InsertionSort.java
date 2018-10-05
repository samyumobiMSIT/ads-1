/**
 * Class for Insertion sort.
 */
class InsertionSort {
	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 */
	public static void sort(final Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1 ; j > 0; j--) {
				if (less(a[j], a[j - 1])) {
					exch(a, j, j - 1);
				} else break;
			}
		}
	}
	/**
	 * { function_description }
	 *
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	private static boolean less(final Comparable i, final Comparable j) {
		return i.compareTo(j) < 0;
	}
	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	private static void exch(final Comparable[] a,
		final int i, final int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}