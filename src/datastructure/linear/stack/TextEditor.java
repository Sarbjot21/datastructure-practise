package datastructure.linear.stack;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor
    {
	    public static void performOperations(String[] input){
	        String result = "",first="",second = "";
	        String[] inputArray = new String[2];
	        Stack<String> undo = new Stack<String>();
	        //System.out.println(input.length);
	        int i = 0;
	        char ch=' ';
	        for(String inputString:input){
	            //System.out.println(inputString);
	            inputArray = inputString.split(" ");
	                first = inputArray[0];
	            if(inputArray.length>1)
		         second = inputArray[1];
	            
	            switch(first){
	                case "1":
	                    result+=second;
	                    break;
	                case "2":
	                    undo.push(result);
	                    int total = result.length();
	                    int lastK = Integer.parseInt(second);
	                    result = result.substring(0,(total-lastK));
	                    break;
	                case "3":
	                    System.out.println(result.charAt(Integer.parseInt(second)-1));
	                    break;
	                case "4":
	                    result = undo.pop();
	            }

	        }
	    }

	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        int numberOfOperations = Integer.parseInt(scan.nextLine().trim());
	        int i=0;
	        String[] input = new String[numberOfOperations];
	        while(i<numberOfOperations){
	            input[i] = scan.nextLine();
	           // System.out.println(input[i]);
	            i++;
	        }

	        performOperations(input);

	    }  

    }
