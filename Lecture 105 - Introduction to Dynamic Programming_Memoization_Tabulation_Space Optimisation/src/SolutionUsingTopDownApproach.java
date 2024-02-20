import java.util.HashMap;
import java.util.Map;

//Memoization + Recursion
class SolutionUsingTopDownApproach
{
    //step 1 initialise dp
    Map<Integer,Integer> dp = new HashMap<>();

    public int fib(int n) {
        if(n <= 1) return n;

        //step 3 check
        if(dp.containsKey(n)) return dp.get(n);

        //step 2 store ans in dp
        dp.put(n, fib(n-1) + fib(n-2));
        return dp.get(n);
    }
}
/*
TC - O(n)
SC - O(n+n) =O(n)
 */