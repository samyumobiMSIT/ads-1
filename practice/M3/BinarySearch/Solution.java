

	public class Solution
	{ 
	    // Returns index of x if it is present in arr[],  
	    // else return -1 
		public int BinarySearchSmallest( int[] A, int key)
		{
			int low = 0;
			int high = A.length - 1;
			while (low <= high)
			{
			    int mid = (low + high) / 2;
			    if (key < A[mid])
			    {
			        if (key > A[mid-1])
			        {
			            return mid;
			        }
			        high = mid - 1;
			    }
			    else if (key > A[mid])
			    {
			        low = mid + 1;
			    }
			    else
			    {
			    return mid;
			    }
			}
			return -1;
		}


	  
	    // Driver method to test above 
	    public static void main(String args[]) 
	    { 
	        Solution ob = new Solution(); 
	        int arr[] = {3, 10, 3, 10, 10,40}; 
	        int x = 10; 
	        int result = ob.BinarySearchSmallest(arr, x); 
	        if (result == -1) 
	            System.out.println("Element not present"); 
	        else
	            System.out.println("Element found at " +  
	                                   "index " + result); 
	    } 
	} 


