/*
Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.

You have to find an integer array D of size A such that:

=> D[i] : Shortest distance form the C node to node i.

=> If node i is not reachable from C then -1.

Note:

There are no self-loops in the graph.

No multiple edges between two pair of vertices.

The graph may or may not be connected.

Nodes are numbered from 0 to A-1.

Your solution will run on multiple testcases. If you are using global variables make sure to clear them.

==========================================================================================================================================
Problem Constraints
        1 <= A <= 1e5
        
        0 <= B[i][0],B[i][1] < A
        
        0 <= B[i][2] <= 1e3
        
        0 <= C < A

*/
public class Solution {
		//To Store <Vertice, Distance> pair.
    class Pair{
        int vertice;
        int distance;
        Pair(int vertice,int distance){
            this.vertice = vertice;
            this.distance = distance;
        }
        public String toString(){
            return "("+vertice+","+distance+")";
        }
    }
		
    public int[] solve(int A, int[][] B, int C) {
				//result array.
        int[] shotestDistanceFromSource = new int[A];
				
        Arrays.fill(shotestDistanceFromSource,-1);
        ArrayList<Pair>[] adjacency = adjacency(A,B);
        findShortestDistanceFromSource(C,adjacency,shotestDistanceFromSource);
        return shotestDistanceFromSource;
    }

    public void findShortestDistanceFromSource(int source,ArrayList<Pair>[] adjacency,int[] shotestDistanceFromSource){
        //<Vertice,DistanceFromSource>
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->(a.distance - b.distance));
        queue.add(new Pair(source,0));
        while(!queue.isEmpty()){
            Pair parent = queue.poll();
						//distance array[parent] != -1 means we have already found shortest distance to this node. 
            if(shotestDistanceFromSource[parent.vertice] == -1)
                shotestDistanceFromSource[parent.vertice] = parent.distance;
            else 
                continue;
						//All the corresponding neighbours for which the distance is yet to calculate will be added to the queue. 
            ArrayList<Pair> neighbours = adjacency[parent.vertice];
            if(neighbours != null){
                for(int i = 0;i<neighbours.size();i++){
                    Pair neighbour = neighbours.get(i);
                    if(shotestDistanceFromSource[neighbour.vertice] == -1){
                        queue.add(new Pair(neighbour.vertice,shotestDistanceFromSource[parent.vertice]+neighbour.distance));
                    }
                }    
            }
        }
    }

    public ArrayList<Pair>[] adjacency(int A, int[][] B ){
        ArrayList<Pair>[] adjacency = new ArrayList[A];
        for(int i = 0;i<B.length;i++){
            int from = B[i][0];
            //vertice,distanceBetweenThem
            int to = B[i][1];
						//Node A -> B with distance.
            Pair fromTo = new Pair(B[i][1],B[i][2]);
						//Node B -> A with distance.
            Pair toFrom = new Pair(B[i][0],B[i][2]);
            if(adjacency[from] == null)
                adjacency[from] = new ArrayList<Pair>();
            if(adjacency[to] == null)
                adjacency[to] = new ArrayList<Pair>();
            adjacency[from].add(fromTo);
            adjacency[to].add(toFrom);
        }
        return adjacency;
    }
}