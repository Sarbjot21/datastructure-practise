package programs.general.practise;

import java.util.*;

public class SumOfN {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
			int n = scan.nextInt();
			System.out.println(n*(n+1)/2);
		}
    }
}