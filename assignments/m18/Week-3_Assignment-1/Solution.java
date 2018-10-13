import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		while(n > 0) {
			int hours = 6;
			while(hours > 0) {
				String[] line = scan.nextLine().split(",");
				System.out.println(line[0] + " - " +line[1]);
				
				hours--;
			}
			System.out.println();
			n--;
		}
	}
}