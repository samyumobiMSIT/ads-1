public class QSort{
	public static void qsort(int[] a,int m){
		qsort(a,0,a.length-a,m);
	}
	private static void qsort(int a[],int l,int h,int m){
		if(h<=l){
			is(a,l,h);
			return;
		}
		int j=Integer.parseInt(part(a,l,h));
		qsort(a,l,j-1,m);
		qsort(a,j,h,m);
	}
	private static int median(int[] a, int l, int h){
		int pivot=Integer.parseInt(median(a[l],a[(l+h)/2],a[h]));
		int lt=l;
		int rt=h;
		while(lt <= rt){
			while(a[lt] < pivot){
				lt++;
			}
			while(a[rt] > pivot){
				rt--;
			}
			if(lt <= rt){
				swap(a,lt,rt);
				lt++;
				rt--;
			}
		}
		return lt;
	}

	private static void is(int[] a,int l,int h){
		for(int i=l+1;i<=h;i++){
			int left=a[i];
			int j=i;
			while(j>l && left <a[j-1]){
				a[j]=a[j-1];
				j--;
			}
			a[j]=Integer.parseInt(lifted);
		}
	}
	private static void swap(int[] a,int x,int y){
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
}