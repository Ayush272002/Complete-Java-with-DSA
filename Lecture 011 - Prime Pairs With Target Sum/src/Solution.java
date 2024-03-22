import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution
{
    private void sieve(boolean[] primes, int n)
    {
        for(int i = 2; i < n; i++)
        {
            if(primes[i])
            {
                for(int j = 2*i; j < n; j = j+i)
                {
                    primes[j] = false;
                }
            }
        }
    }
    public List<List<Integer>> findPrimePairs(int n)
    {
        boolean[] primes = new boolean[n+1];
        Arrays.fill(primes,true);
        primes[0] = primes[1] = false;
        sieve(primes,n);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 2; i <= n; i++)
        {
            int j = n-i;
            if(primes[i] && primes[j] && i <= j)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(j);
                ans.add(temp);
            }
        }

        return ans;
    }
}