import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        int n = nums.length;

        // XOR all elements to get the XOR of the two unique numbers
        for(int i = 0; i < n; i++) {
            res ^= nums[i];
        }

        // Find the rightmost set bit in the result
        int index = 0;
        while((res & (1 << index)) == 0) {
            index++;
        }

        int mask = (1 << index);
        List<Integer> tempArr = new ArrayList<>();

        // Separate numbers based on whether the bit at the index position is set or not
        for (int i = 0; i < n; i++) {
            if((nums[i] & mask) != 0) {
                tempArr.add(nums[i]);
            }
        }

        // XOR all elements with the bit at index position set to get one unique number
        int firstUnique = 0;
        for (int i = 0; i < tempArr.size(); i++) {
            firstUnique ^= tempArr.get(i);
        }

        // The other unique number is obtained by XORing the result with the first unique number
        int secondUnique = res ^ firstUnique;

        // Return the unique numbers in increasing order
        return new int[]{Math.min(firstUnique, secondUnique), Math.max(firstUnique, secondUnique)};
    }
}