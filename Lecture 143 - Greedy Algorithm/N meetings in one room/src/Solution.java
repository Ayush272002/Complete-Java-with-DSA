import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Solution
{
    private static class pair
    {
        int first, second; //start, end

        public pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int[] start, int[] end, int n)
    {
        // add your code here
        List<pair> v = new ArrayList<>();

        for (int i = 0; i < n; i++)
        {
            pair temp = new pair(start[i],end[i]);
            v.add(temp);
        }

        //sort
        Collections.sort(v, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.second - o2.second;
            }
        });

        int count = 1;
        int ansEnd = v.get(0).second;

        for (int i = 0; i < n; i++) {
            if(v.get(i).first > ansEnd)
            {
                count++;
                ansEnd = v.get(i).second;
            }
        }

        return count;
    }
}