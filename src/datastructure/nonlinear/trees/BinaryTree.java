package datastructure.nonlinear.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T>
    {
	BinaryTreeNode root;
	
	public BinaryTree()
	    {
		// TODO Auto-generated constructor stub
		this.root = null;
	    }
	
	public BinaryTreeNode insertElement(BinaryTreeNode root,Integer data) {
		if(root == null)
		    return new BinaryTreeNode(data);
		
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryTreeNode temp;
		while(!queue.isEmpty()) {
		    temp = queue.remove();
		    
		    if(temp.left!=null)
			queue.add(temp.left);
		    else {
			temp.left = new BinaryTreeNode(data);
			break;
		    }
		    if(temp.right!=null)
			queue.add(temp.right);
		    else {
			temp.right = new BinaryTreeNode(data);
			break;
		    }
		    	    
		}	
		return root;
	}
	
	public BinaryTreeNode deleteNode(BinaryTreeNode root,Integer data) {
		if(root == null)
		    return null;
	    	if(root.data == data){
        		if(root.left == null)
        		    root = root.right;
        		else if(root.right == null)
        			root = root.left;
        		else{
        			root.data = this.deepestNode(root.right);
        			System.out.println("Deepest Node data: "+root.data);
        			root.right = deleteNode(root.right, root.data);
        			
        		}
        		return root;
		}
		root.left = deleteNode(root.left, data);
		root.right = deleteNode(root.right, data);
	    return root;   
	}
	
	
	private Integer deepestNode(BinaryTreeNode root)
	    {
		// TODO Auto-generated method stub
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		BinaryTreeNode deepNode = null;
		while(!queue.isEmpty()) {
		    deepNode = queue.remove();
		    if(deepNode.left!=null)
			queue.add(deepNode.left);
		    if(deepNode.right!=null)
			queue.add(deepNode.right);
		}
		Integer data = deepNode.data;
		deepNode = null;
		return data;
	    }

	/* Explanation: At each node we evaluate that the data is:  
	 * root, should lies from minimum(Integer.MIN_VALUE) && maximum(Integer.MAX_VALUE).
	 * If left child, it should lies from the minimum to the parent's node's data. 
	 * If right child, the value should  be between parent node's data and the maximum.
	 * minimum & maximum value would vary based on the side you traverse the tree.
	*/
	public boolean isBST(BinaryTreeNode root,Integer min, Integer max) {
	    if(root == null)
		return true;
	    if(root.data>min&&root.data<max && isBST(root.left,min,root.data)&&isBST(root.right,root.data,max))
		return true;
	    return false;
	}
	
	public void inOrderTraversal(BinaryTreeNode root) {
	    if(root!=null) {
		inOrderTraversal(root.left);
		System.out.println(root.data);
		inOrderTraversal(root.right);
	    }
	}
	
   }
class BinaryTreeNode{
    Integer data;
    BinaryTreeNode left;
    BinaryTreeNode right;
    
    public BinaryTreeNode(Integer data)
	{
	    // TODO Auto-generated constructor stub
	    this.data = data;
	    left = null;
	    right = null;
	}
}
