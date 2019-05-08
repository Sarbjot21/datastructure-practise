/*
 * 
 * Find the Rotation Count in Rotated Sorted array
 * Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
 * Input : arr[] = {15, 18, 2, 3, 6, 12}
 * Output: 2
 * Explanation : Initial array must be {2, 3,6, 12, 15, 18}. 
 * We get the given array after rotating the initial array twice.
 * 
 * 
 */
package datastructure.linear.array;

public class CountRotation
    {
	public static void main (String[] args)  
	    { 
	        int arr[] = {15, 18, 2, 3, 6, 12}; 
	        int n = arr.length; 
	          
	        System.out.println(countRotations(arr, 0, n-1)); 
	    }

	private static int countRotations(int[] arr, int start, int last)
	    {
		// TODO Auto-generated method stub
		        // element 
		        int min = arr[0], min_index = -1;
		        int length=arr.length;
		        for (int i = 0; i < length; i++) 
		        { 
		            if (min > arr[i]) 
		            { 
		                min = arr[i]; 
		                min_index = i; 
		            } 
		        }  
		        return min_index; 
		     
	    } 
	private int countRotationUsingBinarySearch(int[] arr, int start, int last) {
	    if(start>last) 
		return -1;
	    else {
		int mid=start+(last-start)/2;
	    }
	    
	    
	    
	    return 0;
	}
    }
