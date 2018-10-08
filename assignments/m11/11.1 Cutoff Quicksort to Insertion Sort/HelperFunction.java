public class HelperFunctions<T extends Comparable<T>> {

	/* Partitioning function which places the pivot value in the correct
	 * position and puts all elements less than it to the left and all
	 * elements greater than it to the right. Returns the corrected index
	 * of the pivot*/
	 public int partition(T array[], int low, int high) {
	 
		 T pivot = array[high]; 
		 int incrementor = low - 1;
     
		 /*Iterate through the elements in the array
		  * checking if values are lower than the value of the pivot*/
		 for (int j = low; j < high; j++) {
    	 	
    	 		/*If current value is less than the value of the pivot,
    	 		 *swap it with the incrementing index*/
			 if (array[j].compareTo(pivot) <= 0) {
				 incrementor++;
				 array = swap(array, incrementor, j);
			 }
		 }

		 /*Swap the pivot value with the incrementor.
		  * This will put the pivot in the correct position whether any 
		  * other values were swapped and also if the pivot value is 
		  * less than all other elements*/
		 incrementor++;
		 array = swap(array, incrementor, high);

		 return incrementor;
	 }
	 
	 //Partitions an array using median of 3
	 public int partitionMedian(T[] array, int low, int high, T median) {
		 
		 int incrementer = low;
		 int decrementer = high - 1;
		 
		 while (true) {
			 
			 while (array[++incrementer].compareTo(median) < 0);
			 while (array[--decrementer].compareTo(median) > 0);
			 
			 if (incrementer >= decrementer) break;
			 else swap(array, incrementer, decrementer);
		 }
		 
		 swap(array, incrementer, high - 1);
		 return incrementer;
	 }
	 
	 public int partitionIt(T[] intArray, int left, int right, T pivot) {
		    int leftPtr = left;
		    int rightPtr = right - 1;

		    while (true) {
		      while (intArray[++leftPtr].compareTo(pivot) < 0)
		        ;
		      while (intArray[--rightPtr].compareTo(pivot) > 0)
		        ;
		      if (leftPtr >= rightPtr)
		        break;
		      else
		        swap(intArray, leftPtr, rightPtr);
		    }
		    swap(intArray, leftPtr, right - 1);
		    return leftPtr;
		  }
	 
	 //A helper function to swap the values at 2 indices in a given array
	 public T[] swap(T[] array, int i, int j) {
		 T temp = array[i];
		 array[i] = array[j];
		 array[j] = temp;
		 return array;
	 }
	 
	 
	
}