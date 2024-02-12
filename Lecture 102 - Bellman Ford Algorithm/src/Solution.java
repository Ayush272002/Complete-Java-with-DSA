import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Solution {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges)
    {
        // Write your code here.

        List<Integer> distance = new ArrayList<>(Collections.nCopies(n+1,100000000)); // can do Integer.Max_value
        distance.set(src,0);

        for (int i = 1; i <= n; i++) {
            //travers on edge list
            for (int j = 0; j < m; j++) {
                int u = edges.get(j).get(0);
                int v = edges.get(j).get(1);
                int w = edges.get(j).get(2);


                if(distance.get(u) != 100000000 && (distance.get(u) + w < distance.get(v) ))
                {
                    distance.set(v,distance.get(u)+w);
                }
            }
        }

        //check for negative cycle
        boolean flag = false;
        for (int j = 0; j < m; j++) {
            int u = edges.get(j).get(0);
            int v = edges.get(j).get(1);
            int w = edges.get(j).get(2);


            if(distance.get(u) != 100000000 && (distance.get(u) + w < distance.get(v) ))
            {
                flag = true;
                break;
            }
        }

        if(!flag)
        {
            int[] result = new int[n+1];
            for (int i = 0; i <= n; i++) {
                result[i] = distance.get(i);
            }

            return result;
        }
        else return new int[]{-1};

    }
}
