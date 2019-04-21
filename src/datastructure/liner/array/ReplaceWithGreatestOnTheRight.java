package datastructure.liner.array;

public class ReplaceWithGreatestOnTheRight {
	
	public int[] replaceArr(int[] arr) {
		int max = arr[arr.length-1];
		arr[arr.length-1]=-1;
		for(int i=arr.length-2;i>=0;i--) {
			int temp=arr[i];
			arr[i]=max;
			if(max<temp) {
				max=temp;
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReplaceWithGreatestOnTheRight letsDo= new ReplaceWithGreatestOnTheRight();
		int[] arr = new int[] {16,1,4,3,5,2};
		
		arr = letsDo.replaceArr(arr);
		for(int i:arr)
			System.out.print(i+" ");
	}

}
