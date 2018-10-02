import java.util.Scanner;
import  java.util.Arrays;
//Solution class
public class Solution { //Solution class
public static void sort(final Comparable[] a) {//sort method
//sort and compares elements
int n = a.length;
for (int i = 0; i < n; i++ ){
	for (int j = i; j > n; j--) {
		if (less(a[j], a[j - 1])) {
			exch(a, j, j - 1);
		} else {
			break;
		}
	}
		}
	 }
// is v < w ?
	  private static boolean less(final Comparable i,final Comparable j) {
	  	return i.compareTo(j) < 0;
	    }
	    // exchange a[i] and a[j]
	    private static void exch(final Comparable[] a, final int i, final int j) {//exch
	        Comparable swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }
//main method
	    public static final void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
    	String input = scan.nextLine();
    	for (int i = 0; i < Integer.parseInt(input); i++) {
    	String str = scan.nextLine();
    	String[] string = str.split(" ");
    	Solution.sort(string);
    	System.out.println(Arrays.toString(string));
    }
    }
}
