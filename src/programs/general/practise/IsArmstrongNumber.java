package programs.general.practise;

import java.util.*;

public class IsArmstrongNumber {
	public static void main(String[] args) {
		
		// YOUR CODE GOES HERE
		// Please take input and print output to standard input/output (stdin/stdout)
		// DO NOT USE ARGUMENTS FOR INPUTS
		// E.g. 'Scanner' for input & 'System.out' for output
		Map<Integer, Integer> cubeMap = new HashMap<>();
		for (int i = 1; i <= 9; i++) {
			cubeMap.put(i, i * i * i);
		}
		try (Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			for (int i = 1; i <= N; i++) {
				if (isArmStrong(i, cubeMap))
					System.out.println(i);
			}
		}
	}

	public static boolean isArmStrong(int N, Map<Integer, Integer> map) {
		int val = N;
		int sum = 0;
		while (val != 0) {
			if (val % 10 != 0)
				sum += (map.get(val % 10));
			val = val / 10;
		}
		return sum == N;
	}
}
