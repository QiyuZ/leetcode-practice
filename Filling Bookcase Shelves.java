class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1]; //dp[i]前i本书可以取得的最小高度
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) { 
            int width = books[i - 1][0], heigth = books[i - 1][1]; //注意是i-1
            dp[i] = dp[i - 1] + heigth; //如果另起一行就直接加上高
            for (int j = i - 1; j > 0; j--) {  //否则和前面的放在一排，找出最高的那个就是本排的高度
                if (width + books[j - 1][0] > shelf_width) break; //不如越界
                heigth = Math.max(heigth, books[j - 1][1]); //找最高的那个，注意用j-1是第j本书
                width += books[j - 1][0]; 
                dp[i] = Math.min(dp[i], dp[j - 1] + heigth); //比较两种情况的那个最佳
            }
        }
        return dp[books.length];
    }
}
