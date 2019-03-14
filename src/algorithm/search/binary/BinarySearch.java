/*
 * Binary Search: Search a sorted array by repeatedly dividing the search interval in half.
 *  Begin with an interval covering the whole array. If the value of the search key is less 
 *  than the item in the middle of the interval, narrow the interval to the lower half.
 *   Otherwise narrow it to the upper half. Repeatedly check until the value is found 
 *   or the interval is empty.
 *   
*/

package algorithm.search.binary;

public class BinarySearch
    {
	public static void main(String args[]) 
	    { 
	        BinarySearch ob = new BinarySearch(); 
	        int arr[] = { 1, 3, 5,10, 10, 40,50,80,90 }; 
	        int n = arr.length; 
	        int x = 90; 
	        int result = ob.binarySearch(arr, 0, n - 1, x); 
	        if (result == -1) 
	            System.out.println("Element not present"); 
	        else
	            System.out.println("Element found at index " + result); 
	    }

	private int binarySearch(int[] arr, int start, int end, int value)
	    {
		System.out.println("Executing it start:"+start+" end: "+end);
		if(end>0) {
		    
        		int mid=(start+end)/2;
        		if(arr[mid]==value)
        		    return mid;
        		else if(arr[mid]>value)
        		    return binarySearch(arr, start, mid-1, value);
        		else
        		    return binarySearch(arr, mid+1, end, value);
		}
		return -1;
	    } 
	
	
    }
