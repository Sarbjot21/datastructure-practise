package programs.general.practise;

import java.util.*;

public class IsPrime {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int n = scan.nextInt();
			if (isPrime(n))
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	public static boolean isPrime(int N) {
		if (N == 1) {
			return false;
		}
		for (int i = 2; i <= N / i; i++) {
			if (N % i == 0)
				return false;
		}
		return true;
	}
}