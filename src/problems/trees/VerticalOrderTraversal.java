
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
             Ex: 
                  6
                /   \
               3     7
              / \     \
             2   5     9
            
            Output: 
            [ [2],[3],[6, 5],[7],[9] ]

*/
/*
Intuition: We need to return the vertical order or BT. We can use Map as a datastructure because least and highest level(vertically) at left or right
is not declared. 

The result should be in order from least(left) level -> highest level(right), could be any child of root(left or right perhaps).
WE will be using TreeMap, to store the levels in order or sort HashMap at last. 

*/
class Solution {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        if( A == null)
            return output;
        Map<Integer,ArrayList<Integer>> verticalLevelMap = new TreeMap<>();
        verticalOrder(A,verticalLevelMap,0);
        for(ArrayList<Integer> level : verticalLevelMap.values()){
            output.add(level);
        }
        return output;
    }
    public void verticalOrder(TreeNode root,Map<Integer,ArrayList<Integer>> verticalLevelMap,int level){
        if(root == null)
            return;
        
        ArrayList<Integer> currentNodesAtLevel = null;
        if(verticalLevelMap.get(level) == null){
            currentNodesAtLevel = new ArrayList<>();
            verticalLevelMap.put(level,currentNodesAtLevel);
        }else
            currentNodesAtLevel = verticalLevelMap.get(level);
        currentNodesAtLevel.add(root.val);
        verticalOrder(root.left,verticalLevelMap,level-1);
        verticalOrder(root.right,verticalLevelMap,level+1);
    }
}
