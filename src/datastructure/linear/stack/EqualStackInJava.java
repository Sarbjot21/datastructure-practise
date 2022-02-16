package datastructure.linear.stack;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EqualStackInJava {
	/*
	 * Complete the equalStacks function below.
	 */
	static int equalStacks(int[] h1, int[] h2, int[] h3) throws Exception {
		ArrayStack<Integer> s1 = new ArrayStack<Integer>(h1.length);
		ArrayStack<Integer> s2 = new ArrayStack<Integer>(h2.length);
		ArrayStack<Integer> s3 = new ArrayStack<Integer>(h3.length);
		int sum1 = 0, sum2 = 0, sum3 = 0;
		for (int i = h1.length - 1; i >= 0; i--) {
			s1.push(h1[i]);
			sum1 += h1[i];
		}
		for (int i = h2.length - 1; i >= 0; i--) {
			s2.push(h2[i]);
			sum2 += h2[i];
		}
		for (int i = h3.length - 1; i >= 0; i--) {
			s3.push(h3[i]);
			sum3 += h3[i];
		}
		while (!(sum1 == sum2 && sum2 == sum3 && sum3 == sum1)) {
			if (sum1 == 0 || sum2 == 0 || sum3 == 0) {
				sum1 = 0;
				break;
			} else if (sum1 >= sum2 && sum1 >= sum3) {
				sum1 -= s1.pop();

			} else if (sum2 >= sum1 && sum2 >= sum3) {
				sum2 -= s2.pop();

			} else if (sum3 >= sum1 && sum3 >= sum2) {
				sum3 -= s3.pop();

			}
		}
		return sum1;
	}

	public static void main(String[] args) throws Exception {

		final Scanner scanner = new Scanner(System.in);

		String[] n1N2N3 = scanner.nextLine().split(" ");

		int n1 = Integer.parseInt(n1N2N3[0].trim());

		int n2 = Integer.parseInt(n1N2N3[1].trim());

		int n3 = Integer.parseInt(n1N2N3[2].trim());

		int[] h1 = new int[n1];

		String[] h1Items = scanner.nextLine().split(" ");

		for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
			int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
			h1[h1Itr] = h1Item;
		}

		int[] h2 = new int[n2];

		String[] h2Items = scanner.nextLine().split(" ");

		for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
			int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
			h2[h2Itr] = h2Item;
		}

		int[] h3 = new int[n3];

		String[] h3Items = scanner.nextLine().split(" ");

		for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
			int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
			h3[h3Itr] = h3Item;
		}

		int result = equalStacks(h1, h2, h3);
		System.out.println(result);
	}
}

/*
 * Problem Statement: You have three stacks of cylinders where each cylinder has
 * the same diameter, but they may vary in height. You can change the height of
 * a stack by removing and discarding its topmost cylinder any number of times.
 * Find the maximum possible height of the stacks such that all of the stacks
 * are exactly the same height. This means you must remove zero or more
 * cylinders from the top of zero or more of the three stacks until they're all
 * the same height, then print the height. The removals must be performed in
 * such a way as to maximize the height. Note: An empty stack is still a stack.
 * 
 * Sample Input 5 3 4 3 2 1 1 1 4 3 2 1 1 4 1 Sample Output 5
 * 
 */