package datastructure.linear.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class AndOrXor
    {
	private static final Scanner scanner = new Scanner(System.in);

	    /*
	     * Complete the andXorOr function below.
	     */ 
	    
	    static int andXorOr(int[] a) {
	        /*
	         * Write your code here.
	         */
	        Stack<Integer> stack = new Stack<Integer>();
	        int max = a[0]^a[1];
	        for(int i:a){
	            while(!stack.isEmpty()){
	                max = Math.max(max,(i^stack.peek()));
	                if(i<stack.peek()){
	                   stack.pop();
	                }else{
	                    break;
	                }
	            }
	            stack.push(i);
	        }

	        return max;
	    

	    }
	    
	    public static void main(String[] args) throws IOException {
	        int aCount = Integer.parseInt(scanner.nextLine().trim());

	        int[] a = new int[aCount];

	        String[] aItems = scanner.nextLine().split(" ");

	        for (int aItr = 0; aItr < aCount; aItr++) {
	            int aItem = Integer.parseInt(aItems[aItr].trim());
	            a[aItr] = aItem;
	        }

	        int result = andXorOr(a);
	        System.out.println(result);
	    }
	}

    
