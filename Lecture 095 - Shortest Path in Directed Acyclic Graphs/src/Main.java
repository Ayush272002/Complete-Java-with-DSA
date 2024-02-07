import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Main
{
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(0,1,5);
        g.addEdge(0,2,3);
        g.addEdge(1,2,2);
        g.addEdge(1,3,6);
        g.addEdge(2,3,7);
        g.addEdge(2,4,4);
        g.addEdge(2,5,2);
        g.addEdge(3,4,-1);
        g.addEdge(4,5,-2);

        g.printAdjList();

        int n = 6; //no. of nodes in the graph
        //topological sort
        HashMap<Integer, Boolean> visited = new HashMap<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            if(!visited.getOrDefault(i,false))
            {
                g.dfs(i,visited, s);
            }
        }

        int src = 1;
        ArrayList<Integer> distance = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            distance.add(Integer.MAX_VALUE);
        }

        g.getShortestPath(src,distance,s);

        System.out.println("Ans is ");

        for (int i = 0; i < distance.size(); i++) {
            System.out.print(distance.get(i) + " ");
        }
    }
}


/*
output

0->(1,5)  (2,3)
1->(2,2)  (3,6)
2->(3,7)  (4,4)  (5,2)
3->(4,-1)
4->(5,-2)
5->
Ans is
2147483647 0 2 6 5 3

Time complexity - O(n + e)
Space complexity - O(n + e)
 */
