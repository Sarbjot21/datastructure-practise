package datastructure.nonlinear.trees;

import java.util.Vector;

import datastructure.linear.linkedlist.sll.LinkedList;


public class BinarySearchTree<T> {
    BinarySearchTreeNode root;
    
    public BinarySearchTreeNode add(BinarySearchTreeNode root, Integer data){
	if(root == null)
	    return new BinarySearchTreeNode(data);
	if(root.data<=data) {
	    root.right = add(root.right,data);
	}else if (root.data>data){
	    root.left = add(root.left, data);
	}
	return root;
	
    }

    public BinarySearchTreeNode findNode(BinarySearchTreeNode root,Integer data) {
	if(root == null)
	    return null;
	if(root.data<data)
	    return findNode(root.right,data);
	else if(root.data >data)
	    return findNode(root.left,data);
	else
	    return root;
    }
    
    public BinarySearchTreeNode deleteNode(BinarySearchTreeNode root,Integer data) {
	if(root == null)
	    return null;
	if(data>root.data)
	    root.right = deleteNode(root.right,data);
	else if(data<root.data)
	    root.left =  deleteNode(root.left,data);
	else {
	    if(root.left==null)
		return root.right;
	    else if(root.right == null)
		return root.left;
	    else {
		root.data = this.findMin(root.right);
		root.right = deleteNode(root.right, data);
	    }
	}
	return root;	
    }
    
    public BinarySearchTreeNode kthSmallest(BinarySearchTreeNode root,int kth,int count) {
	if(root == null)
	    return null;
	BinarySearchTreeNode left = kthSmallest(root.left, kth,count);
	if(left != null)
	    return left;
	if(++count == kth)
	    return root;
	return kthSmallest(root.right, kth, count);
	
    }
    public Integer findMin(BinarySearchTreeNode root) {
	if(root == null)
	    return null;
	else {
	    if(root.left == null)
		return root.data;
	    else
		return findMin(root.left);
	}
    }
    
    public Integer findMax(BinarySearchTreeNode root) {
	if(root == null)
	    return null;
	else {
	    if(root.right == null)
		return root.data;
	    else
		return findMax(root.right);
	}
    }
    public BinarySearchTreeNode LCA(BinarySearchTreeNode root, BinarySearchTreeNode data1, BinarySearchTreeNode data2) {
	if(root == null)
	    return null;
	else if(root == data1|| root == data2)
	    return root;
	else if(Math.max(data1.data, data2.data)>root.data)
	    return LCA(root.right, data1, data2);
	else if(Math.min(data1.data,data2.data)<root.data)
	    return LCA(root.left,data1,data2);
	else
	    return root;
    }
    
    /* Time Complexity : O(nlogn)
    */
    public static BinarySearchTreeNode construct(Vector<Integer> list, int start, int end)
	{
	    // TODO Auto-generated method stub
	    if(start>end)
		return null;
	    int mid = start+(end-start)/2;
	    BinarySearchTreeNode root = new BinarySearchTreeNode(list.get(mid));
	    root.left = construct(list, start, mid-1);
	    root.right = construct(list, mid+1, end);
	    
	   return root;
	}
    
    
    /*Time Complexity : O(n)
     * 
    */
    public static BinarySearchTreeNode constructTree(LinkedList<Integer>.Node head, int start, int end)
	{
	    // TODO Auto-generated method stub
	    if(start>end)
		return null;
	    int mid = start+(end-start)/2;
	    BinarySearchTreeNode left= constructTree(head, start, mid-1);
	    BinarySearchTreeNode root = new BinarySearchTreeNode(head.getData());
	    root.left = left;
	    if(head.getNext()!=null) {
		head.setData(head.getNext().getData());
		head.setNext(head.getNext().getNext());
	    }
	    root.right = constructTree(head, mid+1, end);
	    
	   
	   return root;
	}
    
    
}

class BinarySearchTreeNode
    {
	  Integer data;
	  BinarySearchTreeNode left;
	  BinarySearchTreeNode right;
	  
	  public BinarySearchTreeNode(Integer data)
	    {
		// TODO Auto-generated constructor stub
		this.data = data;
		this.left = null;
		this.right = null;
	    }
	  
    }