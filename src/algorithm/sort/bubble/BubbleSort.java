package algorithm.sort.bubble;

/*
 * Bubble sort works in iterative way with time complexity of O(n2). In BS we
 * bubble out the highest/lowest element by comparing i and i+1 element from the
 * unsorted section at one side of the array and call it sorted section. In the
 * next iteration we will follow the same and keep on decreasing the length of
 * the unsorted array until it is 0. At 0, we have shifted all the elements to
 * sorted section. This implementation takes care of the iterations happening
 * only to unsorted section, the length of which is decreasing at each
 * iteration. At starting unsortedIndex = 6 and at the end, it is 1.
 * 
 */
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 15, 21, 4, 1, 56, 97, -22 };
		int count = 0;

		for (int unsortedIndex = array.length - 1; unsortedIndex > 0; unsortedIndex--) {
			for (int it = 0; it < unsortedIndex; it++) {
				if (array[it] > array[it + 1]) {
					swap(array, it, it + 1);
				}
				count++;
			}
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
