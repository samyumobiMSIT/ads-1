import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

	public int comparisionCounter = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Prompting user to enter K value which is the max value of input the array should have
		System.out.println("Please enter K value (100 or 1000 or 10000 or 100000): ");
		int K = sc.nextInt();
		QuickSort obj = new QuickSort();
		
		if(K == 100 || K ==  1000|| K ==  10000|| K == 100000)
		{
			obj.initiateSortExperiment(K);
		}
		else
		{
			System.out.println("K should only be 100 or 1000 or 10000 or 100000 ");			
		}		
	}

	//Method which returns partition index for quick sort
	public int partition(int[] arrayValues, int start, int end) {
		int pivot = arrayValues[end];					
		int partitionIndex = start;
		int temp;
		for (int i = start; i < end; i++) {
			comparisionCounter++;
			if (arrayValues[i] <= pivot) {
				temp = arrayValues[i];
				arrayValues[i] = arrayValues[partitionIndex];
				arrayValues[partitionIndex] = temp;
				partitionIndex++;
			}
		}
		temp = arrayValues[partitionIndex];
		arrayValues[partitionIndex] = arrayValues[end];
		arrayValues[end] = temp;
		return partitionIndex;
	}

	//Perform quick sort or insertion sort based on the subfile size
	public int[] quickSort(int[] arrayValues, int start, int end, int cutOff) {
		int partitionIndex;
		//Check whether subfile size is <=cutoff value
		if ((end - start) <= cutOff) {			
			insertionSort(arrayValues, start, end);//Invoke insertion sort	
		} else if (start < end) {
			//Recursively calling QuickSort for sorting subfile
			partitionIndex = partition(arrayValues, start, end);
			quickSort(arrayValues, start, partitionIndex - 1, cutOff);
			quickSort(arrayValues, partitionIndex + 1, end, cutOff);
		}
		return arrayValues;
	}

	//Insertion Sort method
	public void insertionSort(int[] A, int start, int end) {
		int i, j;
		int key;
		for (j = start + 1; j <= end; j++) {
			key = A[j];			
			i = j - 1;
			while (i >= 0 && A[i] > key) {
				comparisionCounter++;
				A[i + 1] = A[i];
				i = i - 1;
			}
			A[i + 1] = key;		
		}
	}

	public void initiateSortExperiment(int K) {				
		int inputArray[] = new int[10000];
		int totCount = 0;
		int M;
		
		/* 
		 We are performing 10 rounds and in each round we intend to invoke quick sort
		 and the subsequent methods for M ranging from 1-500.
		*/
 		for (int round = 1; round <= 10; round++) 
		{
			ArrayList<Integer> a=new ArrayList<Integer>();
			for (M = 1; M <= 500; M++) 
			{
				//Checking comparision value for values of M from 1-500
				totCount = 0;				
				comparisionCounter = 0;

				//Randomly generating values to sort which are less than K 
				for (int j = 0; j < 10000; j++) 
				{
					Random rand = new Random();
					inputArray[j] = rand.nextInt(K - 1) + 1;
				}
				
				int sortedArray[] = quickSort(inputArray, 0, 9999, M);				
				totCount = totCount + comparisionCounter; 
				a.add(totCount);				
			}
			
			ArrayList<Integer> b = new ArrayList<Integer>(a);
			Collections.sort(a);
			int index = b.indexOf((a.get(0)))+1;
			int value = a.get(0);
			System.out.println("In round "+round+": For M = "+ index +" we see the least total comparisions i.e. = "+value);
		}		
	}
}