/*
Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.

Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.

NOTE: Return the answer modulo 109+7 as the answer can be large.

Problem Constraints
1 <= A <= 100000
0 <= C <= 100000
1 <= B[i][0], B[i][1] <= N
1 <= B[i][2] <= 109

Example Input
Input 1:

A = 3
B = [   [1, 2, 14]
        [2, 3, 7]
        [3, 1, 2]   ]
Input 2:

A = 3
B = [   [1, 2, 20]
        [2, 3, 17]  ]


Example Output
Output 1:
9

Output 2:
37


Example Explanation
Explanation 1:

We can take only two edges (2 -> 3 and 3 -> 1) to construct the graph. 
we can reach the 1st node from 2nd and 3rd node using only these two edges.
So, the total cost of costruction is 9.
Explanation 2:

We have to take both the given edges so that we can reach the 1st node from 2nd and 3rd node.

*/
public class Solution {
    class Pair{
        int vertice;
        int distance;
        Pair(int vertice,int distance){
            this.vertice = vertice;
            this.distance = distance;
        }
    }
    public int solve(int A, int[][] B) {
        //A vertices
        int visited[] = new int[A+1];
        int mod = 1000000000 + 7;
        //A+1
        ArrayList<Pair>[] adjacency = adjacency(A,B);

        int noOfVerticesVisited = 0;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a,b)-> a.distance-b.distance);
        minHeap.add(new Pair(1,0));
        long ans = 0;

        while(!minHeap.isEmpty()) {
            Pair currentNode = minHeap.poll();
            int vertice = currentNode.vertice;
            if(visited[vertice] == 0){
                visited[vertice] = 1;
                noOfVerticesVisited++;
                ans += currentNode.distance;
                ArrayList<Pair> neighbours = adjacency[vertice];
                if(neighbours == null)
                    continue;
                for(int i = 0;i<neighbours.size();i++){
                    Pair neighbour = neighbours.get(i);
                    if(visited[neighbour.vertice] == 0)
                        minHeap.add(neighbour);
                }

            }
            if(noOfVerticesVisited == A)
                break;
        }
        return (int) ((ans+mod)%mod);
    }

    public ArrayList<Pair>[] adjacency(int vertices, int[][] relationsWithWeights){
        ArrayList<Pair>[] adjacencyList = new ArrayList[vertices+1];
        for(int i = 0;i<relationsWithWeights.length;i++){
            int from = relationsWithWeights[i][0];
            int to = relationsWithWeights[i][1];
            int weight = relationsWithWeights[i][2];
            
            if(adjacencyList[from] == null)
                adjacencyList[from] = new ArrayList<Pair>();
            if(adjacencyList[to] == null)
                adjacencyList[to] = new ArrayList<Pair>();
            
            Pair fromTo = new Pair(to,weight);
            Pair toFrom = new Pair(from,weight);

            //Add elements with weight on both the vertices in adjacency list. 
            adjacencyList[from].add(fromTo);
            adjacencyList[to].add(toFrom);
        }
        return adjacencyList;
    }
}
