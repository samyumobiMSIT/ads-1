/*
class for Insertion sort
*/
class InsertionSort{

public static void sort(final Comparable[] a){
	int N=a.length;
	for(i=0;i<N;i++){
		for(int j= i +1; j>0;j--) {
			if(less(a[j],a[j-1])){
				exch(a,j,j-1);
			} else break;
		}
	}
}
}