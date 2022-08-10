/*

Maximum array sum after B negations

Problem Description
Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.

*/

public class MaximumSumAfterBNegotiations {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int a : A){
            heap.add(a);
        }
        while(B-->0){
            int value = heap.poll();
            //System.out.println(value);
            heap.add((-1)*value);
        }
        int sum = 0;
        while(!heap.isEmpty()){
            sum += (heap.poll());
        }
        return sum;

    }
}
