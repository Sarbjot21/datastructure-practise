package datastructure.liner.linkedlist.sll;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> {
	Node head,tail;
	int size;
	LinkedList(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	class Node {
		private int data;
		private Node next;
		Node(int data){
			this.setData(data);
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	public void addElement(int data) {
		Node node = new Node(data);
		if(this.size == 0)
			this.head = node;
		else
			this.tail.setNext(node);
		this.tail = node;
		this.size++;
	}
	
	public void printList(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.addElement(4);
		list.addElement(5);
		list.addElement(6);
		list.addElement(7);
		list.addElement(8);
		list.addElement(9);
		list.printList(list.head);
	}
	
	
}
