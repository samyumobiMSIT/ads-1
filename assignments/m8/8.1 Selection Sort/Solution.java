package ADS1;

import java.util.Scanner;  
import java.util.Comparator;
  
public class selectio_sort  
{  
	 public static void sort(Comparable[] a) {
	        int n = a.length;
	        for (int i = 0; i < n; i++) {
	            int min = i;
	            for (int j = i+1; j < n; j++) {
	                if (less(a[j], a[min])) min = j;
	            }
	            exch(a, i, min);
	            assert isSorted(a, 0, i);
	        }
	        assert isSorted(a);
	    }
	 
	 // is v < w ?
	    private static boolean less(Comparable v, Comparable w) {
	        return v.compareTo(w) < 0;
	    }

	    // is v < w ?
	    private static boolean less(Comparator comparator, Object v, Object w) {
	        return comparator.compare(v, w) < 0;
	    }
	        
	        
	    // exchange a[i] and a[j]
	    private static void exch(Object[] a, int i, int j) {
	        Object swap = a[i];
	        a[i] = a[j];
	        a[j] = swap;
	    }

	    private static void show(Comparable[] a) {
	        for (int i = 0; i < a.length; i++) {
	            System.out.println(a[i]);
	        }
	    }

	
   public static void main(String args[])  
   {  
       int size;
	int i, j, temp;  
       String[] arr = new String[50];  
       Scanner scan = new Scanner(System.in);  
         
       System.out.print("Enter Array Size : ");  
       size = scan.nextInt();  
         
       System.out.print("Enter Array Elements : ");  
       for(i=0; i<size; i++)  
       {  
           arr[i] = scan.toString();  
       }  
         
       

         
       System.out.print("Now the Array after Sorting is :\n");  
       for(i=0; i<size; i++)  
       {  
           System.out.print(arr[i]+ "  ");  
       }  
   } 
}  