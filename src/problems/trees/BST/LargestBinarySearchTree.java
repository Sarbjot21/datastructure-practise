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
        public class NodeValue {
        public int maxNode, minNode, maxSize;

        NodeValue(int minNode, int maxNode, int maxSize) {
            this.maxNode = maxNode;
            this.minNode = minNode;
            this.maxSize = maxSize;
        }
    }

    public NodeValue largestBSTSubtree(TreeNode root) {
        // An empty tree is a BST of size 0.
        if (root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        // Get values from left and right subtree of current tree.
        NodeValue left = largestBSTSubtree(root.left);
        NodeValue right = largestBSTSubtree(root.right);

        // Current node is greater than max in left AND smaller than min in right, it is a BST.
        if (left.maxNode < root.val && root.val < right.minNode)
            // It is a BST.
            return new NodeValue(Math.min(root.val, left.minNode), Math.max(root.val, right.maxNode),
                    left.maxSize + right.maxSize + 1);
                    
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public int solve(TreeNode A) {
        return largestBSTSubtree(A).maxSize;
    }
}
