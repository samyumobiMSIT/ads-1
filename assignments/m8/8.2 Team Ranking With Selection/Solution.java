import java.util.Scanner;
import  java.util.Arrays;
//Solution class
public class Solution { //Solution class
public static void sort(final Comparable[] a) {//sort method
//sort and compares elements
int n = a.length,min;
for (int i = 0; i < n; i++ ){
		min=i;
	for (int j = i+1; j < n; j++) {
		if (less(a[j], a[j - 1])) {
			min=j;
			
		} 
	 }exch(a, j, j - 1);
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
	    int i=0;
	    StringBuffer b=new StringBuffer();
	    while(scan.hasNext()){
	    	b.append(scan.nextLine() + ": :");
	    }
	    String[] lines = b.toString().split(": :");
	    Team[] t=new Team[lines.length];
	    for(String line : lines) {
	    	String[] tokens = line.split(",");
            teams[i++] = new Team(tokens[0],
            	Integer.parseInt(tokens[1]),
            	Integer.parseInt(tokens[2]),
            	Integer.parseInt(tokens[THREE]));
	    }

    	/**String input = scan.nextLine();
    	for (int i = 0; i < Integer.parseInt(input); i++) {
    	String str = scan.nextLine();
    	String[] string = str.split(" ");
    	Solution.sort(string);
    	System.out.println(Arrays.toString(string));**/
    	
    }
    }

