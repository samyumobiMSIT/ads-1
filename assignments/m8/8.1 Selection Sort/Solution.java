import java.util.Scanner;  
import java.util.Comparator;
import  java.util.Arrays;

//Solution class
public class Solution {
	public static void sort(final Comparable[] a) {
	//sort and compares elements
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i+ 1; j < n; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}		
			}
			exch(a, i, min);
		}
	 }
	 // is v < w ?
	  private static boolean less(final Comparable i,final Comparable j) {
	  	return i.compareTo(j) < 0;
	    }
	    // exchange a[i] and a[j]
	    private static void exch(final Comparable[] a, final int i, final int j) {
	        Comparable swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }
	    //main method
	    public static void main(String[] args) {
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
    