public class QuickSortMedianOf3<T extends Comparable<T>> {

	HelperFunctions<T> helpers = new HelperFunctions<T>();
	InsertionSort<T> insertionSort = new InsertionSort<T>();
	
	/*Sort method that implements QuickSort with median of 3 partitioning
	 * and switching to InsertionSort at a given cutoff size*/
	public T[] sort(T[] array, int cutoff) {
		return sortAux(array, 0, array.length - 1, cutoff);
	}
	
	/*The recursive call that sorts the elements in the first,mid and last
	 * positions, then puts the median in the last position and uses it
	 * as a pivot */
	public T[] sortAux(T[] array, int low, int high, int cutoff) {
		
		//Uses InsertionSort on array sizes less than a given cutoff 
		if (low + cutoff > high) insertionSort.sort(array);
		
	    else {
	    		
	    		//Find the mid index
	    		int mid = (low + high) / 2;
	    		
	    		//Sort the elements in the first, last and mid indices
	    		if (array[mid].compareTo(array[low]) < 0) helpers.swap(array, low, mid);
	    		if (array[high].compareTo(array[low]) < 0) helpers.swap(array, low, high);
	    		if (array[high].compareTo(array[mid]) < 0) helpers.swap(array, mid, high);
	    		
	    		//Swap the mid element with the last element and assign it as the pivot
	    		helpers.swap(array, mid, high - 1);
	    		T pivot = array[high - 1];
	    		
	    		/*Assign an incrementor and a decrementor to iterate through
	    		 * the array beginning at the 2nd element and 2nd to last element*/
	    		int incrementor, decrementor;
	    		for (incrementor = low ,decrementor = high - 1;;) {
	    			
	    			//Increment until an element greater than the pivot is found
	    			while (array[++incrementor].compareTo(pivot) < 0);
	    			
	    			//Decrement until an element less than the pivot is found
	    			while (pivot.compareTo(array[--decrementor]) < 0);
	    			
	    			//Exit the loop if the incrementor and decrementor point to the same element
	    			if (incrementor >= decrementor) break;
	    			
	    			//Swap the elements at the positions pointed to by incrementor and decrementor
	    			helpers.swap(array, incrementor, decrementor);
	    		}
	    		
	    		//Swap the element pointed to by the incrementor with the last element
	    		helpers.swap(array, incrementor, high - 1);

	    		/*Recursively sort the sub arrays to the left and right of the element pointed 
	    		 * to by incrementor*/
	    		sortAux(array, low, incrementor - 1, cutoff); 
	    		sortAux(array, incrementor + 1, high, cutoff);
	    }
	    return array;
	  }
}