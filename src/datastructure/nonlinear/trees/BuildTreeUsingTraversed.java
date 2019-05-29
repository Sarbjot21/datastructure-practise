package datastructure.nonlinear.trees;

public class BuildTreeUsingTraversed
    {
	public static BinaryTreeNode buildTree(int[] preOrder, int[] inOrder) {
	    if(preOrder.length == 0 || preOrder.length-inOrder.length!=0) {
		return null;
	    }
	    return buildBT(preOrder,0,preOrder.length-1,inOrder,0,inOrder.length-1);
	}
	
	
	private static BinaryTreeNode buildBT(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd)
	    {
		// TODO Auto-generated method stub
		if(preStart>preEnd || inStart>inEnd)
		    return null;
		Integer data = preOrder[preStart];
		//BinaryTree<Integer> tree = new BinaryTree<>();
		BinaryTreeNode curr = new BinaryTreeNode(data);
		int offSet = inStart;
		for(;offSet<inEnd;offSet++) {
		    if(inOrder[offSet]==data)
			break;
		}
		curr.left=buildBT(preOrder, 1+preStart,preStart+offSet-inStart , inOrder, inStart , offSet-1);
		curr.right=buildBT(preOrder, preStart+offSet-inStart+1, preEnd, inOrder, offSet+1, inEnd);
		return curr;
	    }


	public static void main(String[] args)
	    {
		
	    }
    }
