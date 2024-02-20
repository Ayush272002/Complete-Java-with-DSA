import java.util.HashMap;
import java.util.Map;

class SolutionUsingBottomUpApproach
{
    //step 1 : create dp
    Map<Integer,Integer> dp = new HashMap<>();
    public int fib(int n)
    {
        //case 2 : base case
        dp.put(0,0);
        dp.put(1,1);

        //step 3
        for (int i = 2; i <= n; i++) {
            dp.put(i,dp.get(i-1)+dp.get(i-2));
        }

        return dp.get(n);
    }
}

/*
TC - O(n)
SC - O(n)
 */