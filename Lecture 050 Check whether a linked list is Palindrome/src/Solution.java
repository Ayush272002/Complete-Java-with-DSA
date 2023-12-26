import java.util.ArrayList;

class Solution {

    static boolean checkPalindrome(ArrayList<Integer> arr)
    {
        int n = arr.size();
        int start = 0;
        int end = n-1;
        while(start <= end)
        {
            if(arr.get(start) != arr.get(end)) return false;
            start++;
            end--;
        }
        return true;
    }
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp != null)
        {
            arr.add(temp.val);
            temp = temp.next;
        }
        return checkPalindrome(arr);
    }
}