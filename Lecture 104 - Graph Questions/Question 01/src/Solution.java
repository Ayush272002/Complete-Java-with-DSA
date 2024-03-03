import java.util.*;

class Solution {
    public int maximumInvitations(int[] favorite)
    {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int n=favorite.length;

        //1.making the adjacency list named graph
        for(int i=0;i<n;i++)
            graph.put(i,new ArrayList<Integer>());

        for(int i=0;i<n;i++)
            graph.get(i).add(favorite[i]);

        //stack of topological sort
        Stack<Integer> s=new Stack<>();
        //visited array
        HashMap<Integer,Boolean> vis=new HashMap<>();

        //2. topological sort
        for(int i=0;i<n;i++)
        {
            if (!vis.getOrDefault(i,false))
                dfs(i, vis, graph, s);
        }

        //3. initializing reverse/transpose graph
        HashMap<Integer, List<Integer>> rev=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            rev.put(i,new ArrayList<Integer>());
        }
        // filling the reverse graph or rev
        for(int i=0;i<n;i++)
        {
            //making the visited array false as it was used in topological sort
            vis.put(i,false);
            for(int val : graph.get(i))
            {
                rev.get(val).add(i);
            }
        }

        //k is an important variable for edge cases. It's for cycle of 2's
        //more later
        int k=0;
        // queue to get the no of node of all strongly connected components(scc)  in a max heap
        //ie. decreasing order
        PriorityQueue<Integer> q=new PriorityQueue<Integer>((a,b)->b-a);

        // after all 3 steps, now nodes are traversed in dfs according to topological sort
        //stored in stack "s".
        while(!s.isEmpty())
        {
            int node=s.pop();
            //if a node is not visited means a new component, and so we find its length
            // and mark all nodes traversed visited "true" to save on repetition.
            if(!vis.getOrDefault(node,false))
            {
                //finding the length of component and storing in a temporary variable "temp"
                int temp= revDfs(node,vis,rev);
                // now there are 3 cases for our answer
                //1. there are no cycles and graph is linear so length of all components will be 1
                // or there are cycles,cycles are of 2 nodes or more.

                //2.  components with cycles of 2 can also have the longest branch of  both the nodes
                // added to the final length, below segment does that only and more.
                // lengths all the components with cycles of 2  can be added
                //for a buffer answer,thus variable k(why? see solution description),
                // which adds all the final lengths of components with cycle of 2
                if(temp==2)
                {
                    //start with length to 0
                    temp=0;
                    //partner refer to 2nd component of cycle other than node
                    int partner=-1;
                    //finding partner,which is that child of the node whose child is node itself
                    //making a 2 length cycle ie.
                    //  node-->child
                    //     <---

                    for(int child : rev.get(node))
                    {
                        for(int child2 : rev.get(child))
                        {
                            if(node==child2)
                            {
                                partner=child;
                                break;
                            }
                        }
                        if(partner!=-1) break;
                    }
                    //making another visited array to count length of longest branch
                    //including node, other than partner branch and vice versa
                    // and adding to temp
                    HashMap<Integer,Boolean> dfsvis=new HashMap<>();
                    temp+=lengthdfs(node,partner,dfsvis,rev);
                    temp+=lengthdfs(partner,node,dfsvis,rev);
                    //like discussed above add full length of component with cycle of 2 to k
                    k+=temp;
                }
                //3. component has cycle but is greater than 2,length of cycle will be their final
                //length and no branch length will be added
                // the final length of component
                q.offer(temp);
            }
        }
        // largest component
        int size = -1;
        if(!q.isEmpty()) size=q.poll();
        // if k is larger than size that means all combined length of cycles of 2 which is a valid answer
        // is the answer otherwise it is the highest length of cycle
        return Math.max(size, k);
    }

    // dfs to find the highest branch of node other than its cycle partner's
    public int lengthdfs(int node,int partner,HashMap<Integer,Boolean> dfsvis,HashMap<Integer, List<Integer>> graph)
    {
        dfsvis.put(node,true);
        int count=0;
        for(int child : graph.get(node))
        {
            if(child!=partner && !dfsvis.getOrDefault(child,false))
            {
                count=Math.max(count,lengthdfs(child,node,dfsvis,graph));
            }
        }

        dfsvis.put(node,false);
        return count+1;
    }
    //topological sort of graph
    public void dfs(int node, HashMap<Integer,Boolean> vis, HashMap<Integer, List<Integer>> graph, Stack<Integer> s)
    {
        vis.put(node,true);
        for(int child : graph.get(node))
        {
            if(!vis.getOrDefault(child,false))
            {
                dfs(child,vis,graph,s);
            }
        }

        s.push(node);
    }
    // dfs to find the length of cycle of the component
    //this only works if graph(rev) is reversed as components are visible easily
    public int revDfs(int node, HashMap<Integer,Boolean> vis, HashMap<Integer,List<Integer>> graph)
    {
        vis.put(node,true);
        int count=1;
        for(int child : graph.get(node))
        {
            if(!vis.getOrDefault(child,false))
            {
                count+= revDfs(child,vis,graph);
            }
        }

        return count;
    }
}