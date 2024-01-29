import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Enter the number of nodes");
        Scanner x= new Scanner(System.in);
        int n = x.nextInt();

        System.out.println("Enter the number of edges");
        int m = x.nextInt();

        Graph g = new Graph();

        for (int i = 0; i < m; i++)
        {
            int u, v;
            u = x.nextInt();
            v = x.nextInt();

            //creating an undirected graph
            g.addEdge(u,v,false);
        }

        //print graph
        g.printAdjList();;

        x.close();
    }
}
