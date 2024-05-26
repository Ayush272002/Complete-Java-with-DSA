class Solution
{
    public void sortColors(int[] nums)
    {
        int s = 0, i = 0, e = nums.length-1;

        while(i <= e)
        {
            if(nums[i] == 0)
            {
                int temp = nums[s];
                nums[s] = 0;
                nums[i] = temp;

                s++;
                i++;
            }
            else if(nums[i] == 1) i++;
            else
            {
                int temp = nums[e];
                nums[e] = nums[i];
                nums[i] = temp;

                e--;
            }
        }
    }
}