public class Solution {
    public int intSqrt(int x) {
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

    public double morePrecision(int n, int precision, int tempSol) {

        double factor = 1;
        double ans = tempSol;

        for(int i=0; i<precision; i++) {
            factor = factor/10;

            for(double j=ans; j*j<n; j= j+factor ){
                ans = j;
            }
        }
        return ans;
    }

}
