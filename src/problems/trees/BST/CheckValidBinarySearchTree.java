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
class Solution {
    
    public int isValidBST(TreeNode A) {
        if(A == null)
            return 1;
        if(isValidBST(A,Integer.MIN_VALUE,Integer.MAX_VALUE))
            return 1;
        else
            return 0;
    }
    /*
    We can do this by preoder or postorder. But we should prefer postorder traversal to check valid BST,because preorder will reiterate 
    left/right for each node making it O(N^2) at worst case(skewed tree)
    Instead, in postorder, we check left and right first than comparing the current Node. which makes it run in 
    O(N) at worst case as we are not reiterating the left/right subtree for each
    */
    public boolean isValidBST(TreeNode root,int minimumValue,int maxValue){
        if(root == null)
            return true;
        if(isValidBST(root.left,minimumValue,root.val) 
            && isValidBST(root.right,root.val+1,maxValue)
            && root.val > minimumValue && root.val < maxValue)
                return true;
            else
                return false;
    }
}
