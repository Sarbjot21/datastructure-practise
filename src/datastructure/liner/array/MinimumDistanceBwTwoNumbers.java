package datastructure.liner.array;

public class MinimumDistanceBwTwoNumbers {

	public int findMinimum(int[] arr, int x, int y) {
		int prev=-1;
		int minimumDis = Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==x || arr[i]==y)
			{
				if(prev==-1)
					{	
						prev=i;
						continue;
					}
				if(arr[prev]!=arr[i] && minimumDis>(i-prev))
					{
						minimumDis=(i-prev);
						prev=i;
					}
				else 
				{
					prev=i;
				}
			}	
		}
		return minimumDis;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumDistanceBwTwoNumbers letsFind = new MinimumDistanceBwTwoNumbers();
		int minimumDis=letsFind.findMinimum(new int[]{2,0,3,4,0,8,6,2,3,5,6,0,8},4, 8);
		System.out.println(minimumDis);
		
	}

}
