package hackerrank.problems.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DynamicArray {

	// Complete the dynamicArray function below.
	static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		ArrayList<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>();
		List<Integer> result = new ArrayList<Integer>();
		int lastAnswer = 0;
		int seqIndex = -1;
		for (int i = 0; i < n; i++)
			seqList.add(new ArrayList<Integer>());

		for (List<Integer> query : queries) {
			seqIndex = ((query.get(1) ^ lastAnswer) % n);
			if (query.get(0) == 1) {
				// seqIndex=((query.get(1)^lastAnswer)%n);
				seqList.get(seqIndex).add(query.get(2));
			} else {
				lastAnswer = seqList.get(seqIndex).get(query.get(2) % seqList.get(seqIndex).size());
				result.add(lastAnswer);
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(nq[0]);

		int q = Integer.parseInt(nq[1]);

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> result = dynamicArray(n, queries);

		bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();
	}
}

/*
 * Create a list, seqList , of N empty sequences, where each sequence is indexed
 * from 0 to N-1 . The elements within each of the N sequences also use
 * 0-indexing. Create an integer, lastAnswer , and initialize it to 0. The types
 * of queries that can be performed on your list of sequences (seqList) are
 * described below: Query: 1 x y Find the sequence, seq , at index
 * ((x^lastAnswer%N) in seqList. Append integer y to sequence seq. Query: 2 x y
 * Find the sequence, seq , at index ((x^lastAnswer%N) in seqList. Find the
 * value of element y%size in seq (where is the size of ) and assign it to
 * lastAnswer. Print the new value of lastAnswer on a new line
 * 
 * Note: ^ is the bitwise XOR operation, which corresponds to the ^ operator in
 * most languages. Learn more about it on Wikipedia.
 * 
 * Input Format
 * 
 * The first line contains two space-separated integers, (the number of
 * sequences) and (the number of queries), respectively. Each of the subsequent
 * lines contains a query in the format defined above.
 * 
 * Constraints
 * 
 * It is guaranteed that query type will never query an empty sequence or index.
 * Output Format
 * 
 * For each type query, print the updated value of on a new line.
 * 
 * Sample Input
 * 
 * 2 5 1 0 5 1 1 7 1 0 3 2 1 0 2 1 1 Sample Output
 * 
 * 7 3 Explanation
 * 
 * Initial Values:
 * 
 * 
 * = [ ] = [ ]
 * 
 * Query 0: Append to sequence .
 * 
 * = [5] = [ ]
 * 
 * Query 1: Append to sequence . = [5] = [7]
 * 
 * Query 2: Append to sequence .
 * 
 * = [5, 3] = [7]
 * 
 * Query 3: Assign the value at index of sequence to , print .
 * 
 * = [5, 3] = [7]
 * 
 * 7 Query 4: Assign the value at index of sequence to , print .
 * 
 * = [5, 3] = [7]
 * 
 * 3
 * 
 * 
 * 
 */
