public class InsertionSort<T extends Comparable <T>> {

	public T[] sort(T array[]){
		int len=array.length;

		for(int i=1;i<len;i++){
			T item = array[i];
			int j=i-1;

			while(j>=0 && array[j].compareTo(item) > 0){
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=item;
		} 
		return array;
	}
}