package datastructure.linear.array;
/*
 * 
 * Qs : Longest Span with same Sum in two Binary arrays | GeeksforGeeks
 * 
 * Explanation at https://www.youtube.com/watch?v=xtfj4-r_Ahs&list=PLqM7alHXFySEQDk2MDfbwEdjd2svVJH9p
 *  
 *  Status : Not Completed
*/
class CmnSpanOfSameSum 
{ 
	/*static int arr1[] = new int[]{0, 1, 0, 1, 1, 1, 1}; 
	static int arr2[] = new int[]{1, 1, 1, 1, 1, 0, 1}; 
	*/
    	static int arr1[] = {1,	0, 1,0};
    	static int arr2[] = {1, 1, 1,1};
	// Returns length of the longest common sum in arr1[] 
	// and arr2[]. Both are of same size n. 
	static int longestCommonSum(int n) 
	{ 
		//int maxLen=0;
		int i=0;
		int sum=0;
		while(i<n) {
		    sum+=(arr1[i]-arr2[i]);
		    i++;
		}
		
		return (n+sum);
		
		
	} 
	
	// Driver method to test the above function 
	public static void main(String[] args) 
	{ 
		System.out.print("Length of the longest common span with same sum is "); 
		System.out.println(longestCommonSum(arr1.length)); 
	} 
} 