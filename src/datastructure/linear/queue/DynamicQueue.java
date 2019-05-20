package datastructure.linear.queue;

public class DynamicQueue<T> {
	private int CAPACITY;
	private int size;
	private int front,rear;
	private Object[] arr;
	
	public DynamicQueue() {
		// TODO Auto-generated constructor stub
		this.CAPACITY = 8;
		this.size = 0;
		this.front =0;
		this.rear = -1;
		arr = new Object[CAPACITY];
	}
	
	public int size() {
		return this.size;
	}
	private void enqueue(T data) {
		if(isFull()) {
			expand();
			System.out.println("Expanded to "+CAPACITY);
		}
		rear=(rear+1)%CAPACITY;
		size++;
		arr[rear] = data;		
	}
	
	private T dequeue() throws Exception {
		if(isEmpty())
			throw new Exception("Stack is Empty");
		T data = (T) arr[this.front];
		front = (front+1)%CAPACITY;
		size--;
		return data;
	}
	
	
	private void display() {
		int temp = front;
		while(temp!=rear) {
			System.out.print(arr[temp]+" ");
			temp+=1%CAPACITY;
			System.out.println("Debug: "+temp);
		}
	}
	
	private void expand() {
		Object[] newArr = new Object[CAPACITY<<1];
		for(int i = 0;i<size;i++) {
			newArr[i]=arr[(i+front)%CAPACITY];
		}
		arr = newArr;
		front = 0;
		rear = this.size()-1;
		CAPACITY*=2;
		
	}
	private boolean isFull() {
		// TODO Auto-generated method stub
		return size == CAPACITY;
	}
	
	private boolean isEmpty() {
		return size ==0;
	}
	
	
	
	public static void main(String[] args) {
		DynamicQueue<Integer> queue= new DynamicQueue<>();
		try {
			queue.enqueue(25);
			queue.enqueue(26);
			queue.enqueue(15);
			queue.enqueue(23);
			queue.enqueue(24);
			queue.enqueue(65);	
			queue.enqueue(7);
			queue.enqueue(45);
			System.out.println(queue.dequeue());

			queue.enqueue(10);
			queue.enqueue(100);
			queue.enqueue(35);
			queue.enqueue(2);
			
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
