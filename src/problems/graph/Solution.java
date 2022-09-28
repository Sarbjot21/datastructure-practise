import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(int[] A, final int B, final int C) {
        
        HashMap<Integer,Set<Integer>> adjacency = new HashMap<>();
        for(int i = 1;i<A.length;i++){
            adjacency.getOrDefault(A[i],new HashSet<Integer>()).add(i+1);
        }

        return findPath(B,C,adjacency,new int[A.length][2]);

    }
    public int findPath(int to,int from, HashMap<Integer,Set<Integer>> adjacency,int[][] visited){
        if(visited[from-1][0] == 1)
            return visited[from-1][1];
        visited[from-1][0] = 1;
        if(from == to){
            visited[from-1][1] = 1;
            return 1;
        }
        Set<Integer> children = adjacency.get(from);
        for(int child:children){
            if(visited[child-1][0] == 0)
                visited[from-1][1] = findPath(to,child,adjacency,visited);
            else{
                visited[from-1][1] = visited[child-1][1];
            }
            if(visited[from-1][1] == 1)
                    break;
        }
        return visited[from-1][1];
    }
}
