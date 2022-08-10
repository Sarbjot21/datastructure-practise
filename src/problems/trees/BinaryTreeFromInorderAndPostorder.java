/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index = 0;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int totalElements = inorder.length;
        index = totalElements - 1;
        Map<Integer,Integer> inOrderMap = new HashMap<>();
        for(int i = 0;i<totalElements;i++){
            inOrderMap.put(inorder[i],i);
        }
        return buildTreeHelper(inorder,postorder,0,totalElements-1,inOrderMap);
    }
    
    public TreeNode buildTreeHelper(int[] inOrder,int[] postOrder,int inorderStart,int inOrderEnd,Map<Integer,Integer> inOrderMap){
        if(inorderStart > inOrderEnd)
            return null;
        TreeNode root = new TreeNode(postOrder[index--]);
        int indexOfElement = inOrderMap.get(root.val);
        root.right = buildTreeHelper(inOrder,postOrder,indexOfElement + 1,inOrderEnd,inOrderMap);
        root.left = buildTreeHelper(inOrder,postOrder,inorderStart,indexOfElement-1,inOrderMap);
        return root;
    }
}