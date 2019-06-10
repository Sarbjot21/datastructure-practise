package datastructure.linear.array;

import java.io.*;
import java.util.*;

public class ReverseArray {

	// Complete the reverseArray function below.
	static int[] reverseArray(int[] a) {
		int it = a.length / 2;
		int size = a.length - 1;
		int i = 0;
		int temp = 0;
		while (i < it) {
			temp = a[i];
			a[i++] = a[size];
			a[size--] = temp;
		}
		return a;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("./output.txt"));

		int arrCount = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[arrCount];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < arrCount; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int[] res = reverseArray(arr);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

		scanner.close();
	}
}
