package datastructure.liner.linkedlist.sll;

import datastructure.liner.linkedlist.sll.LinkedList.Node;

public class FindMiddle {
	
	 /* Function to print middle of linked list */
    static void printMiddle(Node head) 
    { 
        Node slow_ptr = head; 
        Node fast_ptr = head; 
        if (head != null) 
        { 
            while (fast_ptr != null && fast_ptr.getNext() != null) 
            { 
                fast_ptr = fast_ptr.getNext().getNext(); 
                slow_ptr = slow_ptr.getNext(); 
            } 
            System.out.println("The middle element is [" + 
                                slow_ptr.getData() + "] \n"); 
        } 
    } 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList();
		list.addElement(3);
		list.addElement(4);
		list.addElement(5);
		list.addElement(6);
		list.addElement(7);
		list.addElement(8);
		list.addElement(1);
		list.addElement(1);
		FindMiddle.printMiddle(list.head);
		
	}

}
