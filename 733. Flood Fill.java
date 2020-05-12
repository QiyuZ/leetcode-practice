class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[sr][sc] == newColor) return image; //newColor就是原来的则不用变
        int m = image.length, n = image[0].length;
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    private void dfs(int[][] image, int x, int y, int newColor, int origin) { 
        //可以不用visited因为visited过的一定image[x][y] != origin，第一行已经排除了相等的情况
        int m = image.length, n = image[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || image[x][y] != origin) return;
        image[x][y] = newColor;
        dfs(image, x + 1, y, newColor, origin);
        dfs(image, x - 1, y, newColor, origin);
        dfs(image, x, y + 1, newColor, origin);
        dfs(image, x, y - 1, newColor, origin);
    }
}
