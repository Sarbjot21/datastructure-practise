package hackerrank.problems.arrays;
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner scan = new Scanner(System.in);
	   // int testcases = scan.nextInt();
	    
	   // for(int i = 1;i<=testcases;i++){
	        int numberOfElem = scan.nextInt();
	        System.out.println(numberOfElem);
	        int[] array = new int[numberOfElem];
	        for(int j = 0;j<numberOfElem;j++)
	            array[j] = scan.nextInt();
	        int res = findOddOneOut(array,0,numberOfElem-1);       
	        System.out.println(res);
	    //}
	    
	 }
	 
	 public static int findOddOneOut(int[] element, int low, int high){
		 int res = 0,mid;
		 while ((high - low) >= 2) {
				if (element[low] != element[low + 1]) {
					res = low;
					break;
				} else if (element[high] != element[high - 1]) {
					res = high;
					break;
				} else {
					mid = (low + high) / 2;
					if (isEven(mid - low + 1)) {
						if (element[mid] == element[mid - 1]) {
							low = mid + 1;
						} else {
							high = mid - 1;
						}
					} else {
						if (element[mid] == element[mid - 1]) {
							high = mid - 2;
						} else if (element[mid] == element[mid + 1]) {
							low = mid + 2;
						} else {
							res = mid;
							break;
						}
					}
				}
		    }
		 return element[res];
    }
    private static boolean isEven(int element){
        return element%2==0;
    }
}
