package datastructure.nonlinear.trees;

import java.util.Vector;

import datastructure.linear.linkedlist.sll.LinkedList;

public class Main
    {

	public static void main(String[] args)
	    {
		// TODO Auto-generated method stub
		/*Vector<Integer> list = new Vector<>();
		list.addElement(10);
		list.addElement(20);
		list.addElement(30);
		list.addElement(40);
		list.addElement(50);
		list.addElement(60);
		list.addElement(70);
		list.addElement(80);*/
		LinkedList<Integer> list = new LinkedList<>();
		list.addElement(10);
		list.addElement(20);
		list.addElement(30);
		list.addElement(40);
		list.addElement(50);
		list.addElement(60);
		list.addElement(70);
		list.addElement(80);
		
		//BinarySearchTreeNode root = BinarySearchTree.constructTree(head, 0, list.size()-1);
		int len = 0;
		LinkedList<Integer>.Node temp = list.getHead();
		while(temp!=null) {
		    len++;
		    temp = temp.getNext();
		}
		BinarySearchTreeNode root = BinarySearchTree.constructTree(list.getHead(), 0, len-1);
		
		traverseBinarySearchTree(root);
		
		System.out.println("\n"+list.getHead().getData());
	    }

	private static void traverseBinarySearchTree(BinarySearchTreeNode root)
	    {
		// TODO Auto-generated method stub
		if(root!=null){
		    traverseBinarySearchTree(root.left);
		    System.out.print(root.data+" ");
		    traverseBinarySearchTree(root.right);
		}
	    }

    }
