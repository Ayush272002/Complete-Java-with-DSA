import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static int kthLargest(int N, int K, int[] Arr) {
        // code here

        ArrayList<Integer> sum_store = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = i; j < N; j++) {
                sum += Arr[j];
                sum_store.add(sum);
            }
        }

        Collections.sort(sum_store);

        return sum_store.get(sum_store.size()-K);
    }
}