import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    ArrayList<Integer> reverse(ArrayList<Integer> ans)
    {
        int s=0, e = ans.size()-1;

        while(s<e)
        {
            int temp = ans.get(s);
            ans.set(s,ans.get(e));
            ans.set(e,temp);
            s++;
            e--;
        }
        return ans;
    }
    public ArrayList<Integer> findArraySum(int[] arr1, int n, int[] arr2, int m)
    {
        int i=n-1, j = m-1, carry =0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i>=0 && j>=0)
        {
            int val1 = arr1[i];
            int val2 = arr2[j];
            int sum = val1+val2+carry;

            carry = sum/10;
            sum = sum%10;
            ans.add(sum);
            i--;
            j--;
        }
        while(i>=0)
        {
            int sum = arr1[i] + carry;
            carry = sum/10;
            sum = sum%10;
            ans.add(sum);
            i--;
        }
        while(j>=0)
        {
            int sum = arr2[j] + carry;
            carry = sum/10;
            sum = sum%10;
            ans.add(sum);
            j--;
        }

        while(carry!=0)
        {
            int sum =carry;
            carry = sum/10;
            sum = sum%10;
            ans.add(sum);
        }
        return reverse(ans);
    }
}
