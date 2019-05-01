package datastructure.liner.linkedlist;

import datastructure.liner.linkedlist.LinkedList.Node;

public class PositionFromTail {

	static int getNode(Node head, int positionFromTail) {
		 Node node = head;
		 Node current = head;
	        int index = 0;
	        while(current!=null){
	            current = current.getNext();
	            if(index > positionFromTail)
	                node = node.getNext();        
	            else 
	                index++;
	        }
	        return node.getData();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<>();
		list.addElement(4);
		list.addElement(5);
		list.addElement(6);
		list.addElement(7);
		list.addElement(8);
		list.addElement(9);
		System.out.println(getNode(list.head,4));
	}

}
