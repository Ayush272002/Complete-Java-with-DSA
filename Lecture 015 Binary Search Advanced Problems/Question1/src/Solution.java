public class Solution {

    boolean isPossible(int[] arr, int n, int m, int mid)
    {
        int sCount =1, pSum=0;
        for (int i = 0; i < n; i++) {
            if(pSum+arr[i]<=mid)
                pSum = pSum+arr[i];
            else {
                sCount++;
                if(sCount> m || arr[i]>mid)
                    return false;

                pSum = arr[i];
            }
        }
        return true;
    }
    int allocate(int[] arr, int n, int m)
    {
        int s=0, sum =0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        int e = sum;
        int mid = s+(e-s)/2;
        int ans =-1;
        while(s<=e)
        {
            if(isPossible(arr, n, m, mid))
            {
                ans = mid;
                e = mid-1;
            }
            else
                s = mid+1;

            mid = s+(e-s)/2;
        }
        return ans;
    }
}
