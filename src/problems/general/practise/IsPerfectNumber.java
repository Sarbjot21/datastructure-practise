package programs.general.practise;

import java.util.*;

public class IsPerfectNumber {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int noOfArg = scan.nextInt();
			for (int i = 1; i <= noOfArg; i++) {
				int arg = scan.nextInt();
				if (isPerfectNumber(arg))
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

	public static boolean isPerfectNumber(int N) {
		int sum = 1;
		for (int i = 2; i <= N / i; i++) {
			if (N % i == 0) {
				int quo = N / i;
				if (quo != i)
					sum += ((quo != i ? quo : 0) + i);
			}
		}
		return sum == N;
	}
}