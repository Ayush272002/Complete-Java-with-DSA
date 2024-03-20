class Solution {
    public int singleNumber(int[] nums)
    {
        int n = nums.length;
        int[] count = new int[32]; //set bit position

        for (int i = 0; i < n; i++)
        {
            int x = nums[i];
            int j = 0; // index
            while(x != 0)
            {
                count[j] += x&1;
                j++;
                x = x>>>1; // use unsigned right shift operator
            }
        }

        int ans = 0, pos = 1;
        for (int i = 0; i < 32; i++)
        {
            count[i] %= 3;
            ans += count[i] * pos;
            pos = pos << 1;
        }

        return ans;
    }
}