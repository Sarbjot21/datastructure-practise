package datastructure.liner.linkedlist;

import datastructure.liner.linkedlist.LinkedList.Node;

public class MergeSortedLinkedLists {
	
	static Node mergeLists(Node head1, Node head2) {
		Node temp;
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        

        if(head1.getData()<=head2.getData()){
            head1.setNext(mergeLists(head1.getNext(),head2));
        }else{
            temp = head2;
            head2 = head2.getNext();
            temp.setNext(head1);
            head1= temp;
            head1.setNext(mergeLists(head1.getNext(),head2));
        }
        return head1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		list1.addElement(2);
		list1.addElement(3);
		list1.addElement(10);
		
		list2.addElement(1);
		list2.addElement(5);
		list2.addElement(10);
		
		Node head = mergeLists(list1.head, list2.head);
		
		list2.printList(head);
		
	}

}
