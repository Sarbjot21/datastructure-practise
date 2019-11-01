package datastructure.nonlinear.trees.heaps;

/**
 * Introduction: It’s a complete tree (All levels are completely filled except
 * possibly the last level and the last level has all keys as left as possible).
 * This property of Binary BinaryHeap makes them suitable to be stored in an array.
 * 
 * 
 * 
 */

public class BinaryHeap {
	    private int[] heapArray;
	    /** size of array **/
	    private int maxSize; 
	    /** number of nodes in array **/
	    private int heapSize; 
	 
	    /** Constructor **/
	    public BinaryHeap(int mx) 
	    {
	        maxSize = mx;
	        heapSize = -1;
	        heapArray = new int[maxSize]; 
	    }
	    /** Check if BinaryHeap is empty **/
	    public boolean isEmpty() 
	    {
	        return heapSize == -1;
	    }
	    /** Function to insert element **/
	    public boolean insert(int ele) 
	    {
	        if (heapSize + 1 == maxSize)
	            return false;
	        heapArray[++heapSize] = ele;
	        int pos = heapSize;
	        while (pos != 1 && ele > heapArray[pos/2])
	        {
	            heapArray[pos] = heapArray[pos/2];
	            pos /=2;
	        }
	        heapArray[pos] = ele;    
	        return true;
	    } 
	 
	    /** function to remove element **/
	    public int remove()
	    {
	        int parent, child;
	        int item, temp;
	        if (isEmpty() )
	            throw new RuntimeException("Error : BinaryHeap empty!");
	 
	        item = heapArray[0];
	        temp = heapArray[heapSize--];
	 
	        parent = 0;
	        child = 1;
	        while (child <= heapSize)
	        {
	            if (child < heapSize && heapArray[child] < heapArray[child + 1])
	                child++;
	            if (temp >= heapArray[child])
	                break;
	 
	            heapArray[parent] = heapArray[child];
	            parent = child;
	            child *= 2;
	        }
	        heapArray[parent] = temp;
	 
	        return item;
	    }
	 
	    /** Function to print values **/
	    public void displayHeap()
	    {
	        /* Array format */
	        System.out.print("\nHeap array: ");    
	        for(int i = 1; i <= heapSize; i++)
	            System.out.print(heapArray[i] +" ");
	        System.out.println("\n");
	    }  
	
}
