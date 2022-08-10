/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */

/*
Given a binary tree of integers denoted by root A. Return an array of integers
representing the top view of the Binary tree.

The top view of a Binary Tree is a set of nodes visible when the tree is
visited from the top.

Return the nodes in any order.

Input 1:

 
            1
          /   \
         2    3
        / \  / \
       4   5 6  7
      /
     8 
     
Output 1:

 [1, 2, 4, 8, 3, 7]
*/
class Solution {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> output = new ArrayList<>();
        if(A == null)
            return output;
        Set<Integer> visitedLevels = new HashSet<>();
        verticalOrder(A,visitedLevels,output,0);
        return output;
    }

    public void verticalOrder(TreeNode root, Set<Integer> visitedLevels,ArrayList<Integer> output,int level){
        if(root == null)
            return;
        
        if(!visitedLevels.contains(level)){
            visitedLevels.add(level);
            output.add(root.val);
        }
        
        verticalOrder(root.left,visitedLevels,output,level-1);
        verticalOrder(root.right,visitedLevels,output,level+1);
    }
}
