import java.util.*;

public class Selection {

	private static int minIndexElement(Comparable[] a, int index) {
		int min = index;
		int N = a.length;
		for (int i = min + 1; i < N; i++)
			if (less (a[i], a[min]))
				min = i;

		return min;
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int minIndex = minIndexElement(a, i);
			exch(a, i, minIndex);
		}
	}
}