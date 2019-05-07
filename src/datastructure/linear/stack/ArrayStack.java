package datastructure.linear.stack;

import java.lang.reflect.Array;


public class ArrayStack<E> {
		int top;
		Object[] arr ;
		@SuppressWarnings("unchecked")
		ArrayStack(int size){
			this.top = -1;
			this.arr = new Object[size];
		}
		
		public void push(E data) throws Exception {
			if(isFull())
				throw new Exception("Stack is Full");
			arr[++top] = data;
			
		}
		
		public E pop() throws Exception {
			if(isEmpty())	
				throw new Exception("Stack is Empty");
			return (E) arr[top--];
		}
		
		public E peek() throws Exception {
			if(isEmpty())	
				throw new Exception("Stack is Empty");
			return (E) arr[top];
		}
		private boolean isFull() {
			return top==arr.length;
		}
		private boolean isEmpty() {
			return top==-1;
		}
		public static void main(String[] args) {
			ArrayStack<Integer> arr = new ArrayStack<>(10);
			try {
					//This will raise Exception, because it is empty.
					//arr.pop();
					arr.push(10);
					arr.push(20);
					System.out.println(arr.peek());
					System.out.println(arr.pop());
					System.out.println(arr.pop());
					System.out.println(arr.pop());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
}
