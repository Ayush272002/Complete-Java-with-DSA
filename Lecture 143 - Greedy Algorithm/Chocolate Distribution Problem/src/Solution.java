import java.util.ArrayList;
import java.util.Collections;

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);
        int i = 0, j = m-1;
        int mini = Integer.MAX_VALUE;

        while(j < a.size())
        {
            int diff = a.get(j) - a.get(i);
            mini = Math.min(mini,diff);
            i++;
            j++;
        }

        return mini;
    }
}