package algorithm.sort.selection;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 15, 21, 4, 1, 56, 97, -22 };
		int count = 0;

		for (int unsortedIndex = array.length - 1; unsortedIndex > 0; unsortedIndex--) {
			int largestIndex = 0;
			for (int i = 1; i <= unsortedIndex; i++) {
				count++;
				if (array[i] > array[largestIndex])
					largestIndex = i;
			}
			swap(array, largestIndex, unsortedIndex);
		}
		display(array);
		System.out.println("No. of Steps taken : " + count);

	}

	private static void display(int[] array) {
		// TODO Auto-generated method stub
		System.out.print("[ ");
		for (int i : array)
			System.out.print(i + " ");
		System.out.print("]\n");
	}

	private static void swap(int[] array, int i, int j) {
		// TODO Auto-generated method stub
		if (i == j)
			return;
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
