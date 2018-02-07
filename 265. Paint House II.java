class Solution {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = -1, min2 = -1;
        //记录两个最小的要取的j，为什么2个？如果相邻颜色可以相同那么就一直取最小的就可以，
        //但是这里要求颜色不同，所以取最小的可能会有冲突，所以min2相当于planB，在满足题意下找最小
        for (int i = 0; i < n; i++) {
            int pre1 = min1, pre2 = min2; //接收上一轮的选取方法
            min1 = -1; min2 = -1; //初始化，因为可能会变动,就是求出每一轮的颜色选择，但是都不保存，最后返回最后一行的最小值即可
            for (int j = 0; j < k; j++) {
                //以下是计算基于前面最小值costs[i][j]的值
                if (j != pre1) costs[i][j] += pre1 < 0 ? 0 : costs[i - 1][pre1]; 
                else costs[i][j] += pre2 < 0 ? 0 :costs[i - 1][pre2];
                //比较并更新min1,min2
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {//如果min初始化-1，这点会出错
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) min2 = j;
            }
        }
        return costs[n - 1][min1];
    }
}
