package programs.general.practise;

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
     static boolean first = true;
     public static void main (String[] args)
        {
        	 //code
        	    Scanner scan = new Scanner(System.in);
        	    int testcases = scan.nextInt();
        	    for(int i = 1;i<=testcases;i++){
        	        int numberOfElem = scan.nextInt();
        	        int[] array = new int[numberOfElem];
        	        for(int j = 0;j<numberOfElem;j++)
        	            array[j] = scan.nextInt();
        	        int elementToFind = scan.nextInt();
        	        int res = findIndex(array,0,array.length-1,elementToFind);       
        	        System.out.println(res);
        	    }
        	    
    	 }
	 
	 private static int findIndex(int[] arr, int low, int hi, int element){
        if(low>hi){
            return -1;
        }
        int mid=-1,left = -1,right = -1;;
        /*if(first){
	         first = false;
	         mid = findRotatedIndex(arr,low,hi);
	    }*/
	    /*if(mid==-1)
	    */
	    mid=low+(hi-low)/2;
	    if(arr[mid] == element)
	        return mid;
	    /*left = findIndex(arr,low,mid-1,element);
	    */
	    /*if(left!=-1)
	        return left;*/
	    if(arr[low]<=arr[hi])
	    {
	    	if(arr[mid]<element)
	    		low = mid+1;
	    	else
	    		hi = mid-1;
	    }
	    else{
	    	if(element <arr[mid])
	            {
	            if(element<arr[low])
	                low = mid + 1;
	            else
	                hi = mid - 1;
	        }else{
	           if(arr[mid]<arr[hi] && element>arr[hi])
	                hi = mid - 1;
	           else 
	        	   low = mid + 1;     
	        }
	    //right= findIndex(arr,mid+1,hi,element);
	    }
	    return findIndex(arr,low,hi,element);
	    
	    
	     
	 }
	 
	 private static int findRotatedIndex(int[] arr,int low,int hi){
	     if(arr[low]<arr[hi] || low>hi)
	        return -1;
	     int mid = low+(hi-low)/2;
	     if(mid == 0 || mid == arr.length-1)
	        return -1;
	     if(arr[mid]>arr[mid+1]){
	         return mid;
	     }else if(arr[low]<arr[mid]){
	         low = mid+1;
	     }else{
	         hi = mid-1;
	     }
	     return findRotatedIndex(arr,low,hi);
	 }
	 
}