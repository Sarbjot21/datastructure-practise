/*
Problem Statement: 
Q1. First non-repeating character
Attempted
character backgroundcharacter
Stuck somewhere?
Ask for help from a TA and get it resolved.
Get help from TA.
Problem Description
Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
B is formed such that we have to find the first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.

Problem Constraints
1 <= |A| <= 100000*/


/*
Intution: 
*/
class Solution {
    public String solve(String A) {
        if(A == null || "".equals(A))
            return A;
        Map<Character,Integer> freqMap = new HashMap<>();
        Queue<Character> distinctCharacterQueue = new LinkedList<>();
        char[] inputCharArray = A.toCharArray();
        StringBuilder output = new StringBuilder();
        output.append(inputCharArray[0]);
        distinctCharacterQueue.add(inputCharArray[0]);
        freqMap.put(inputCharArray[0],1);
        for(int i = 1;i<inputCharArray.length;i++){
            int count = 0;
            if(freqMap.get(inputCharArray[i]) != null){
                count = freqMap.get(inputCharArray[i]);
            }
            freqMap.put(inputCharArray[i],count+1);
            if(((int)freqMap.get(inputCharArray[i])) == 1){
                distinctCharacterQueue.add(inputCharArray[i]);
            }
            //System.out.println(inputCharArray[i]+" "+freqMap.get(inputCharArray[i]));
           //System.out.println(distinctCharacterQueue);
            while(!distinctCharacterQueue.isEmpty() 
                && freqMap.get(distinctCharacterQueue.peek()) > 1)
                    distinctCharacterQueue.poll();       
            //System.out.println(distinctCharacterQueue);
            if(distinctCharacterQueue.isEmpty())
                output.append("#");
            else
                output.append(distinctCharacterQueue.peek());
        }
        return output.toString();
    }
}