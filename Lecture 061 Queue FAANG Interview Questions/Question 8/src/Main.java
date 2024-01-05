public class Main {
    public static void main(String[] args) {
        int[] arr = {2,5,-1,7,-3,-1,-2};
        int k = 4;
        Solution s = new Solution();
        int ans = s.solve(arr,7,k);
        System.out.println(ans);    //ans should be 18
    }
}
