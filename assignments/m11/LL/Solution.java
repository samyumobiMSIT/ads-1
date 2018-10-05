import java.util.Scanner;
import java.util.Arrays;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < test; i++) {
			QSort qs = new QSort();
			int cutoff = Integer.parseInt(scan.nextLine());
			Comparable[] a = scan.nextLine().split(" ");
			qs.qsort(a, 0, a.length - 1, cutoff);
			System.out.println(Arrays.toString(a));
		}
	}
}