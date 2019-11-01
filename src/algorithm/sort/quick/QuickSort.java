package algorithm.sort.quick;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 98,78,68,58,48,38,28,100 };
		//start = 0, end = length-1
		quickSort(array, 0, array.length-1);
		display(array);
	}

	private static void quickSort(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		if (end - start < 2)
			return;
		int pvtIndex = partition(array, start, end);
		quickSort(array, start, pvtIndex-1);
		quickSort(array, pvtIndex+1, end);
	}

	private static int partition(int[] array, int start, int end) {
		// TODO Auto-generated method stub
		int pivot = array[end];
		int i = start;
		int pIndex = start;
		
		//Index : end-2 -> second last element , end-1 -> last element is reserved as pivot.
		while (i < end) {
			if (array[i] <= pivot ) {
				if(i!=pIndex)
					swap(array, i, pIndex);
				pIndex++;
			}
			i++;
		}
		swap(array, pIndex, end);
		return pIndex;
	}

	private static void swap(int[] array, int i, int pvtIndex) {
		// TODO Auto-generated method stub
		int temp = array[i];
		array[i] = array[pvtIndex];
		array[pvtIndex] = temp;
	}

	private static void display(int[] array) {
		// TODO Auto-generated method stub
		System.out.print("[ ");
		for (int i : array)
			System.out.print(i + " ");
		System.out.print("]\n");
	}
}
