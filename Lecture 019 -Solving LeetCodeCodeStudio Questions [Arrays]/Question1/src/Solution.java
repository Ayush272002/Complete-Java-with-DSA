public class Solution
{
    void reverse(int[] arr, int m)
    {
        int s = m+1, e = arr.length-1;

        while(s<=e)
        {
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e]= temp;
            s++;
            e--;
        }

    }
}
