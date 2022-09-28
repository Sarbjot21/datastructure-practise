public class Solution{
	
	public boolean isValid(int row, int col){
		return !(row < 0 || col < 0|| row >= n || col >= m);
	}

	public int getNoOfIslands(int[][] matrix){
		int count = 0;
		int n = matrix.length;
		int m = matrix[0].length;
		int x = {-1,1,0,0};
		int y = {0,0,-1,1}
		int[][] visited = new int[n][m];
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++){
				if(matrix[i][j] == 1 && visited[i][j] != 1){
					dfs(matrix,visited,i,j,n,m,x,y);
					count++;
				}
			}
		}
		
		return count;
	}

	public void dfs(int[][] matrix,int[][] visited,int i,int j, int N, int M, int[] x, int[]y){
		visited[i][j] = 1;
		for(int k  = 0;k<4;k++){
			int neighX = i + x[k];
			int neighY = j + y[k];

			if(isValid(neighx,neighy)){
				if(matrix[neighX][neighY] == 1 
					&& visited[neighX][neighY] != 1){
					dfs(neighX,neighY);
				}
			}
		}
	}

}