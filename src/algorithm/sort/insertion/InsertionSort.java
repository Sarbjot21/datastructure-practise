package algorithm.sort.insertion;

public class InsertionSort {

	/*
	 * We start iterating the array from index 1, assuming the first element in the
	 * array to be sorted. We store the firstUnsortedElement to newElement We
	 * compare the newElement with the sorted section of the array one by one
	 * starting from last index of sorted section. We keep on shifting the elements
	 * to right until we find the index of the element which is having less value
	 * than the newElement.
	 */
	public static void main(String[] args) {

		int[] array = { 15, 21, 7, 1, -45, 0, 98 };
		int length = array.length;
		for (int firstUnsortedArrayIndex = 1; firstUnsortedArrayIndex < length; firstUnsortedArrayIndex++) {
			int newElement = array[firstUnsortedArrayIndex];
			int i = firstUnsortedArrayIndex;

			while (i > 0 && array[i - 1] > newElement) {
				array[i] = array[i - 1];
				i--;
			}
			array[i] = newElement;
		}
		display(array);
	}

	private static void display(int[] array) {
		// TODO Auto-generated method stub
		System.out.print("[ ");
		for (int i : array)
			System.out.print(i + " ");
		System.out.print("]\n");
	}

}
