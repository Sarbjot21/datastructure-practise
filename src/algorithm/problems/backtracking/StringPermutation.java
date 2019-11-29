package algorithm.problems.backtracking;

import java.io.Serializable;

// Java program to print all permutations of a 
// given string. 
public class StringPermutation {
	
	public static void main(String[] args) 
	{ 
		String str = "ABC"; 
		int n = str.length(); 
		StringPermutation StringPermutation = new StringPermutation(); 
		StringPermutation.permuteOwn(str, 0, n-1); 
		//System.out.println(count);
	} 

	/** 
	* StringPermutation function 
	* @param str string to calculate StringPermutation for 
	* @param l starting index 
	* @param r end index 
	*/
	
	private void permuteOwn(String str, int left, int right) {
		if(left == right) {			
			System.out.println(str+" ");
		}
	
		for(int i = left+1;i<=right;i++) {
			str = swap(str, left, i);	
			permuteOwn(str,left+1,right);	
		}
	
		
	}

	/** 
	* Swap Characters at position 
	* @param a string value 
	* @param i position 1 
	* @param j position 2 
	* @return swapped string 
	*/
	public String swap(String a, int i, int j) 
	{ 
		a.charAt(1);
		char temp; 
		char[] charArray = a.toCharArray(); 
		temp = charArray[i] ; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		return String.valueOf(charArray); 
	} 

} 

// This code is contributed by Mihir Joshi 
