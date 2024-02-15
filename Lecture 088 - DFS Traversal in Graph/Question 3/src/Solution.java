class Solution {
    private void dfs(int sr, int sc, int[][] img, int color, int iniColor, int r, int c)
    {

        if (sr < 0 || sr >= r || sc < 0 || sc >= c || img[sr][sc] != iniColor) {
            return; // bounds check and color check added
        }
        img[sr][sc] = color;

        dfs(sr+1, sc, img, color, iniColor, r, c);
        dfs(sr-1, sc, img, color, iniColor, r, c);
        dfs(sr, sc-1, img, color, iniColor, r, c);
        dfs(sr, sc+1, img, color, iniColor, r, c);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color)
    {
        int[][] ans = image; // so that we dont tamper the original data

        int start = image[sr][sc];
        if(start != color)
            dfs(sr,sc,ans,color, image[sr][sc],ans.length, ans[0].length);
        return ans;
    }
}