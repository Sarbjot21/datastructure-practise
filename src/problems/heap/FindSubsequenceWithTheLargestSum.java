/*
Problem Statement:

Leetcode: https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/

You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.

*/


class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>
                    (Comparator.comparingInt(i -> nums[i]));
        for (int i = 0; i < nums.length; ++i) {
            if(pq.isEmpty() || pq.size()<k)
                pq.offer(i);
            else if(nums[i] > nums[pq.peek()]){
                pq.poll();
                pq.add(i);
            }
        }
        return pq.stream().sorted().mapToInt(i -> nums[i]).toArray();
    }
}