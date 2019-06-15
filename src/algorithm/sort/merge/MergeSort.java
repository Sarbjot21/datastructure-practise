package algorithm.sort.merge;

/*
 * 
 * Introduction: Merge Sort Algorithm.
 * 			It is a Divide and Conquer algorithm i.e we are going to divide the problems into subproblems and get the 
 * solution by solving the subproblems. It has two phases.
 * i) Splitting phase(mergeSort) : We are going to split the array into half and do it recursively to the left and right half arrays 
 * until there are one element left at each half.
 * ii) Merging phase(merge): After splitting the arrays into left & right arrays, we'll start merging the arrays in bottom up 
 * approach. We will compare the first element at left array and right array and store the smaller in temporary array.
 * 
 * */

public class MergeSort {

	public static void main(String[] args) {
		int[] array = { 15, 21, 7, 1, -45, 0, 98 };
		mergeSort(array);
		display(array);
	}
	
	//Splitting phase
	private static void mergeSort(int[] array) {
			int length = array.length;
			if(length==1)
				return;
			int mid = length/2;
			int[] left = new int[mid];
			int[] right = new int[length-mid];
			for(int i =0;i<mid;i++)
				left[i] = array[i];
			for(int i=mid;i<length;i++) 
				right[i-mid] = array[i];			
			mergeSort(left);
			mergeSort(right);
			merge(array,left,right);
	}
	
	//Used to Merge the two sorted array
	//{ 1, 7, 25 || -45, 0,21, 98 }
	private static void merge(int[] array, int[] left, int[] right) {
		// TODO Auto-generated method stub
		int i=0,j=0,nL = left.length,nR = right.length,k=0;
		
		//Loop until one array is over
		while(i<nL&&j<nR)
				array[k++]= (left[i]<=right[j]?left[i++]:right[j++]);
		
		//if right array is over.
		while(i<nL)
			array[k++]=left[i++];
		
		//if left array is over.
		while(j<nR)
			array[k++] = right[j++];
	
	}

	private static void display(int[] array) {
		// TODO Auto-generated method stub
		System.out.print("[ ");
		for (int i : array)
			System.out.print(i + " ");
		System.out.print("]\n");
	}
}
