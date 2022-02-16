package datastructure.linear.array;

public class RotateArray {
	/* Function to left rotate arr[] of size n by d */
	/*
	 * void leftRotate(int arr[], int d, int n) { for (int i = 0; i < d; i++)
	 * leftRotatebyOne(arr, n); }
	 * 
	 * void leftRotatebyOne(int arr[], int n) { int i, temp; temp = arr[0]; for (i =
	 * 0; i < n - 1; i++) arr[i] = arr[i + 1]; arr[i] = temp; }
	 */
	/* utility function to print an array */
	void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		RotateArray rotate = new RotateArray();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		arr = rotate.leftRotate(arr, 6, 7);
		rotate.printArray(arr, 7);
	}

	private int[] leftRotate(int[] arr, int times, int n) {
		// TODO Auto-generated method stub
		int rotate[] = new int[n];
		int tempo = 0;
		for (int st = 0; st < n; st++) {
			if (st < n - times) {
				rotate[st] = arr[st + times];
			} else {
				rotate[st] = arr[tempo];
				tempo++;
			}
		}
		return rotate;
	}
}
