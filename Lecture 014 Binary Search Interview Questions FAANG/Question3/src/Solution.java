public class Solution {
    public int mySqrt(int x) {
        int s=0, e=x;
        long  mid = s+(e-s)/2;
        long ans =-1;
        while(s<=e)
        {
            long sq = mid*mid;
            if(sq == x)
                return (int)mid;

            if(sq<x)
            {
                ans =mid;
                s =(int) mid+1;
            }
            else
                e = (int) mid -1;

            mid = s+(e-s)/2;
        }
        return (int)ans;
    }
}
