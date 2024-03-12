import java.util.Arrays;
import java.util.Comparator;

class Solution
{
    private boolean check(int[] base, int[] newBox) {
        return newBox[0] <= base[0] && newBox[1] <= base[1] && newBox[2] <= base[2];
    }

    private int solve(int[][] nums)
    {
        int n = nums.length;
        int[] cur = new int[n+1];
        int[] next = new int[n+1];

        for (int curr = n-1; curr >= 0 ; curr--)
        {
            for (int prev = curr-1; prev >= -1; prev--)
            {
                //include
                int include = 0;
                if(prev == -1 || check(nums[curr], nums[prev]))
                {
                    include = nums[curr][2] + next[curr+1];
                }

                //exclude
                int exclude = next[prev+1];

                cur[prev+1] = Math.max(include,exclude);
            }

            System.arraycopy(cur,0,next,0,n+1);
        }

        return next[0];
    }
    public int maxHeight(int[][] cuboids)
    {
        //step 1 : sort all dimensions for every cuboid
        for(int[] cuboid : cuboids) Arrays.sort(cuboid);

        //step 2 : sort all cuboids on basis of height
        Arrays.sort(cuboids, Comparator.comparingInt(a -> (a[0] + a[1] + a[2])));

        //step 3 : use Longest increasing substring logic
        return solve(cuboids);
    }
}