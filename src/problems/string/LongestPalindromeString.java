class Solution {
    /*https://leetcode.com/problems/longest-palindromic-substring/
    */
    /*
        Intuition : Treat every char as the potential middle of a palindrome(could be max).
        1. It could be even length palindrome
        2. it could be odd length palindrome.
        3. there could be repetitive chars around assumed middle.

        set two pointer one to left and right of middle(or continuous duplicates around middle ), 
        Skip all the duplicates(middle) on left and right. 
    */
    public String longestPalindrome(String input) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < input.length(); i++) {
            //StringBuffer sb = new StringBuffer();
            //sb.append(input.charAt[i]);
            char c = input.charAt(i);
            int left = i;
            int right = i;
            //Moving left to first non-matching middle element at left.
            while (left >= 0 && input.charAt(left) == c) {
                left--;
            }

            //Moving right to first non-matching middle element at right.

            while (right < input.length() && input.charAt(right) == c) {
                right++;
            }

            //Start matching and keep track of left and right pointer. 
            while (left >= 0 && right < input.length()) {
                if (input.charAt(left) != input.charAt(right)) {
                    break;
                }
                left--;
                right++;
            }


           // left + 1 and right - 1 are actually the start and end index of the Palindromic string
            // we don't set "right" because String.substring function required end index exclusively
            left = left + 1;
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }

        return input.substring(start, end);
    }
}
