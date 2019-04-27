package hackerrank.problems.arrays;

import java.io.IOException;
import java.util.Scanner;

public class MaxNumberAfterMOperations {
	   // Complete the arrayManipulation function below.
	    static long arrayManipulation(int n, int[][] queries) {
	        long max=0;
	        long[] resultArray = new long[n];
	        
	        for(int[] query : queries){
	            resultArray[query[0]-1]+=query[2];
	            if(query[1]<n){
	                resultArray[query[1]]-=query[2]; 
	            }
	        }
	        long temp=0;
	        for(long item:resultArray)
	        {
	            temp+=item;
	            if(temp>max)
	                max=temp;
	        }
	        return max;
	   }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        String[] nm = scanner.nextLine().split(" ");

	        int n = Integer.parseInt(nm[0]);

	        int m = Integer.parseInt(nm[1]);

	        int[][] queries = new int[m][3];

	        for (int i = 0; i < m; i++) {
	            String[] queriesRowItems = scanner.nextLine().split(" ");
	            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	            for (int j = 0; j < 3; j++) {
	                int queriesItem = Integer.parseInt(queriesRowItems[j]);
	                queries[i][j] = queriesItem;
	            }
	        }

	        long result = arrayManipulation(n, queries);
	        System.out.println(result);
	        scanner.close();
	    }
	}



/*
 * 
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.

For example, the length of your array of zeros . Your list of queries is as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  between the indices  and  inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
The largest value is 10 after all operations are performed.

Sample Input :
5 3
1 2 100
2 5 100
3 4 100

O/P : 200
 */