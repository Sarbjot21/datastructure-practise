package datastructure.linear.linkedlist.dll;

public class DoublyLinkedList {
	DoublyLinkedListNode head;
	DoublyLinkedListNode tail;
	DoublyLinkedList(){
		this.head = null;
		this.tail = null;
	}
	class DoublyLinkedListNode{
		int data;
		DoublyLinkedListNode next;
		DoublyLinkedListNode prev;
		DoublyLinkedListNode(int data){
			this.data = data;
			this.next = null;
			this.prev = null;
			
		}
	}
	
	public void addFirst(int data) {
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		if(this.head != null)
		{
			node.next = this.head;
			node.next.prev = node;
		}else {
			this.tail = node;
		}
		
		this.head  = node;
	}
	
	public void addLast(int data) {
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		if(this.tail == null) {
			this.head = node;
		}else {
			this.tail.next = node;
			node.prev = this.tail;
		}
		this.tail = node;
	}
	
	public void printList(DoublyLinkedListNode head) {
		DoublyLinkedListNode temp = head;
		if(temp == null)
			return;
		System.out.println("\n=========PRINTING IN FORWARD DIRECTION============\n");
		do {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}while(temp!=null);
		
		System.out.println("\n\n=========PRINTING IN BACKWARD DIRECTION============");
		temp = this.tail;
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
		
	}
	
	public void insertNode(int pos, int data) {
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		DoublyLinkedListNode temp = this.head;
		int index = 0;
		while(temp!=null && index<pos-1) {
			temp = temp.next;
			index++;
		}
		//Position is higher than the number of nodes present.
		if(temp == null)
			return;
		
		node.prev = temp.prev;
		node.next = temp;
		temp.prev.next = node;
		temp.prev = node;
		
	}
	
	public DoublyLinkedListNode deleteFirst() {
		this.head = this.head.next;
		this.head.prev = null;
		return this.head;
	}
	
	public DoublyLinkedListNode deleteLast() {
		this.tail=this.tail.prev;
		this.tail.next = null;
		return this.head;
	}
	
	public void deleteNodeAt(int pos) {
		DoublyLinkedListNode temp = this.head;
		int index = 0;
		while(temp!=null && index < pos-1) {
			temp = temp.next;
			index++;
		}
		
		if(temp ==null)
			return;
		
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		
	}
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.addLast(3);
		list.addLast(5);
		list.addLast(6);
		list.addLast(7);
		list.addLast(8);
		list.addLast(9);
		list.addLast(2);
		list.printList(list.head);
		
		//list.insertNode(2, 20);
		//list.insertNode(7, 00);
		list.head = list.deleteFirst();
		list.printList(list.head);
		list.head = list.deleteLast();
		list.printList(list.head);
		list.deleteNodeAt(4);
		list.printList(list.head);
		
		
		
		
		
		
	}
}
