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
    Return Right View of Binary Tree
*/
class Solution {
    public ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> output = new ArrayList<>();
        if(A == null)
            return output;
        List<List<Integer>> levelMap = new LinkedList<>();
        Queue<Integer> elementsQueue = new LinkedList<>();  
        elementsQueue.add(A);
        while(!elementsQueue.isEmpty()){
            int size = elementsQueue.size();
            List<Integer> nodesAtThisLevel = new ArrayList<>();
            while(size-- > 0){
                TreeNode parentNode = elementsQueue.poll();
                nodesAtThisLevel.add(parentNode);
                if(parentNode.left != null)
                    elementsQueue.add(parentNode.left);
                if (parentNode.right != null)
                    elementsQueue.add(parentNode.right);
            }
            levelMap.add(nodesAtThisLevel);
        }
        for(List<Integer> currentLevel : levelMap){
            output.add(currentLevel.get(currentLevel.size() - 1))
        }
        return output;
    }
}
