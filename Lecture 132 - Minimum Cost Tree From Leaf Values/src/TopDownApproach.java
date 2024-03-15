import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TopDownApproach
{
    private static class Pair<K,V>
    {
        K first;
        V second;

        public Pair(K first, V second)
        {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            return 31 * first.hashCode() + second.hashCode();
        }
    }

    private int solve(int[] arr, Map<Pair<Integer,Integer>, Integer> maxi, int left, int right, int[][] dp)
    {
        if(left == right) return 0;
        if(dp[left][right] != -1) return dp[left][right];

        int ans = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            ans = Math.min(ans, maxi.get(new Pair<>(left,i)) * maxi.get(new Pair<>(i+1,right)) + solve(arr,maxi, left, i, dp) + solve(arr,maxi,i+1,right, dp));
        }

        return dp[left][right] = ans;
    }
    public int mctFromLeafValues(int[] arr)
    {
        Map<Pair<Integer,Integer>, Integer> maxi = new HashMap<>();
        int[][] dp = new int[arr.length+1][arr.length+1];
        Arrays.stream(dp).forEach(r->Arrays.fill(r,-1));

        for (int i = 0; i < arr.length; i++) {
            maxi.put(new Pair<>(i, i),arr[i]);

            for (int j = i+1; j < arr.length; j++) {
                maxi.put(new Pair<>(i, j), Math.max(arr[j], maxi.get(new Pair<>(i, j - 1))));
            }
        }

        return solve(arr,maxi, 0, arr.length-1, dp);
    }
}