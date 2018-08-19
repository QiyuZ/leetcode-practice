class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;
        int origin = image[sr][sc];
        fill(sr, sc, image, origin, newColor);
        return image;
    }
    public void fill(int sr, int sc, int[][] image, int origin, int newColor) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >=image[0].length || image[sr][sc] != origin) return;
        image[sr][sc] = newColor;
        fill(sr + 1, sc, image, origin, newColor); //和数岛问题一样
        fill(sr - 1, sc, image, origin, newColor);
        fill(sr, sc + 1, image, origin, newColor);
        fill(sr, sc - 1, image, origin, newColor);
    }
}
