import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Bellman ford algorithm
class Solution {
    public int networkDelayTime(int[][] times, int n, int k)
    {
        List<Integer> distance = new ArrayList<>(Collections.nCopies(n+1,Integer.MAX_VALUE));
        distance.set(k,0);

        for(int i=1; i<n; i++)
        {
            //edge list
            for (int j = 0; j < times.length; j++) {
                int u = times[j][0];
                int v = times[j][1];
                int w = times[j][2];

                if(distance.get(u) != Integer.MAX_VALUE && (distance.get(u) + w <  distance.get(v)))
                {
                    distance.set(v,w+distance.get(u));
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(distance.get(i) != Integer.MAX_VALUE) ans = Math.max(ans,distance.get(i));
            else return -1;
        }

        return ans;
    }
}