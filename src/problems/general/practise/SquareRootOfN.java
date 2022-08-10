package programs.general.practise;

import java.util.Scanner;

public class SquareRootOfN {
    public static int solve(int A) {
        int i = 1;
        for(;i<A/i;i++){

        }
        if(i == A/i)
            return i;
        return -1;
    }
    
    public static void main(String args[]) {
    	
    	try (Scanner scan = new Scanner(System.in)) {
    		int number = scan.nextInt();
    		System.out.println(solve(number));
		}
    	
    }
}
