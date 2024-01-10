class Solution {
    int[] solve(Node root, int sum, int len, int maxSum, int maxLen) {
        // base case
        if (root == null)
        {
            if (len > maxLen)
            {
                maxLen = len;
                maxSum = sum;
            }
            else if (len == maxLen) 
                maxSum = Math.max(sum, maxSum);

            return new int[]{maxSum, maxLen};
        }
        sum = sum + root.data;

        int[] leftResult = solve(root.left, sum, len + 1, maxSum, maxLen);
        int[] rightResult = solve(root.right, sum, len + 1, leftResult[0], leftResult[1]);

        return new int[]{rightResult[0], rightResult[1]};
    }

    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        int len = 0;
        int maxLen = 0;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        int[] result = solve(root, sum, len, maxSum, maxLen);
        return result[0];
    }
}
