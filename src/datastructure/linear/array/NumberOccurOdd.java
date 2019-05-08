package datastructure.linear.array;

/*
 * INTRODUCTION:
 * A number occuring odd times in an array.
 * The array contains elements which occurs even number of times except one element which occurs odd. Find that element.
 * 1) Brute Force (O(n*n))
 * 2) HashMap (O(n))
 * 3) XOR operation (O(n))
 * 		i) A^A = 0
 * 		ii) 0^A = A
 * The element which is occuring odd number of times will left at the end.
*/
public class NumberOccurOdd {

	
	public int getOddOccurence(int[] arr){
		int res=0;
		for (int i: arr) {
			res^=i;
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOccurOdd odd=new NumberOccurOdd();
		System.out.println(odd.getOddOccurence(new int[]{3,6,5,5,6,2,3,3,2,3,10,1,1}));
	}

}
