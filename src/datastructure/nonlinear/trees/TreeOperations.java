package datastructure.nonlinear.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeOperations
    {
	/*Post Order Traversal will traverse the nodes in LRD or RLD fashion
	 * i.e The left and right subtree are processed first than processing
	 * the current node. 
	 * */	
	public static void postOrderTraversal(BinaryTreeNode root) {
	    if(root == null) {
		return;
	    }
	    postOrderTraversal(root.left);
	    postOrderTraversal(root.right);
	    System.out.println(root.data);
	}
	/*
	*It will find the number of leaves in a tree. A leaf is a node which has 
	*no child nodes.
	*/
	public static int numberOfLeaves(BinaryTreeNode root) {
	    int count = 0;
	    Queue<BinaryTreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    BinaryTreeNode temp = null;
	    while(!queue.isEmpty()) {
		temp = queue.remove();
		
		if(temp.left==null && temp.right==null)
		    count++;
		
		if(temp.left!=null) 
		    queue.add(temp.left);
		if(temp.right!=null)
		    queue.add(temp.right);
	    }
	    return count;
	}
	
	/*
	 * Depth/Height of a tree is the tree is one and the same thing. Height is 
	 * the distance between the root and the deepest node (Leaf node). Or you can say
	 * till which level the tree is spread.
	 * Otherwise depth of a node is the distance of current node from the root.
	 * Similarly Height of the node is the length of the deepest node from the current node.  
	*/
	public static int minDepth(BinaryTreeNode root) {
	    if(root==null || (root.left==null && root.right==null))
		return 0;
	    int left = 0,right = 0;
	    if(root.left !=null) {
		left = minDepth(root.left);
	    }
	    if(root.right!=null) {
		right = minDepth(root.right);
	    }
	    
	    //if(left>0 && right>0) {
	return 1+(left<right?left:right);
	    //}
	   // return 1+(left==0?right:left);
	}
	
	/*Full node is a node which has both right and left child nodes.
	*/
	
	public static int numberOfFullNodes(BinaryTreeNode root) {
	    int count = 0;
	    Queue<BinaryTreeNode> queue = new LinkedList<>();
	    queue.add(root);
	    BinaryTreeNode temp = null;
	    while(!queue.isEmpty()) {
		temp = queue.remove();
		
		if(temp.left!=null && temp.right!=null)
		    count++;
		
		if(temp.left!=null) 
		    queue.add(temp.left);
		if(temp.right!=null)
		    queue.add(temp.right);
	    }
	    return count;
	}
	
	
	/*
	 * This function is used to print the ancestors of a node with the given value.
	*/
	public static boolean printAncestors(BinaryTreeNode root,Integer node) {
	  if(root == null)
	    return false;
	 
	  if(root.data==node||printAncestors(root.left, node)|| printAncestors(root.right, node))
	      {
		  System.out.println(root.data);
		  return true;
	      }
	  return false;
	}
	
	/*
	 *Helper function to check if the tree is BST. 
	 */
	static int checkMax(BinaryTreeNode root){
	     if(root == null) {
		 return Integer.MIN_VALUE;
	     }else {
	        return Math.max(root.data,Math.max(checkMax(root.left),checkMax(root.right)));
	     }
	    }
	/*
	 *Helper function to check if the tree is BST. 
	 */
	static int checkMin(BinaryTreeNode root){ 
	    if(root == null) {
		return Integer.MAX_VALUE;
	    }
	    return Math.min(root.data,Math.min(checkMin(root.left),checkMin(root.right))); 
	}
	
	/*
	 *Function to check if the tree is BST. 
	 */
	static boolean checkBST(BinaryTreeNode root) {
	    int max = Integer.MIN_VALUE;
	    if(root!=null){
	        max = root.data;
	        int maxInLeft = checkMax(root.left);
	        int minInRight = checkMin(root.right);
	        if(max>maxInLeft && max<minInRight)
	            return true;
	    }
	    return false;
	}
	    
	
	public static void main(String[] args)
	    {
		// TODO Auto-generated method stub
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.root=tree.insertElement(tree.root, 40);
		//System.out.println(tree.root.data);
		tree.root=tree.insertElement(tree.root, 30);
		tree.root=tree.insertElement(tree.root, 50);
		tree.root=tree.insertElement(tree.root, 70);
		tree.root=tree.insertElement(tree.root, 10);
		tree.root=tree.insertElement(tree.root, 20);
		tree.root=tree.insertElement(tree.root, 80);
		tree.root=tree.insertElement(tree.root, 90);
		tree.root=tree.insertElement(tree.root, 96);
		tree.root=tree.insertElement(tree.root, 76);
		tree.root=tree.insertElement(tree.root, 56);
		tree.root=tree.insertElement(tree.root, 5);
		tree.root=tree.insertElement(tree.root, 7);
		tree.inOrderTraversal(tree.root);
		//ystem.out.println(tree.isBST(tree.root,-1 ,Integer.MAX_VALUE));
		
		tree.root=tree.deleteNode(tree.root, 40);
		tree.inOrderTraversal(tree.root);
		
		System.out.println("Number of Leaves in the tree is "+numberOfLeaves(tree.root));
		System.out.println("Minimum Depth of tree is :"+minDepth(tree.root));
		System.out.println("Number of full nodes in the tree is "+numberOfFullNodes(tree.root));
		
		printAncestors(tree.root, 5);
	    }

    }
