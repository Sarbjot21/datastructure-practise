package datastructure.liner.array;
/*
 * 
 * Leader : A leader element is an element which is greater than all the elements at its right.
 * ex: {16,17,4,3,5,2}
 * Leader Elements : 17 , 5, 2.
 * The rightmost element is always a leader. 
 * 
 * There are two ways of doing this.
 * 1) Simple(O(n*n))
 * 2) Tricky(O(n))
 * 
 * 
*/

public class LeaderInArray {
	public void findLeaderTricky(int arr[]) {
		int end = arr.length-1;
		int leader = arr[end];
		System.out.print(arr[end] +" ");
		for(int i=end-1;i>-1;i--) {
			if(arr[i]>leader)
			{
				System.out.print(arr[i]+ " ");
				leader = arr[i];
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeaderInArray letsFind = new LeaderInArray();
		letsFind.findLeaderTricky(new int[]{30,20,5,4,6,7,2});
	}

}
