class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] glasses = new double[query_row + 1][query_row + 1]; 
        //此处注意第二个也是query_row + 1表明一行中最多的个数，否则如果是个query_glass是个特别小的数那么前几行后面无法计算
        if (poured <= 0) return 0.0;
        glasses[0][0] = poured; //初始化
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) { //注意此处是<=i因为当前的酒只能留到下一行两侧，eg. (1,0) -> (2,0), (2,1)
                double remain = glasses[i][j] - 1.0;
                if (remain > 0) {
                    glasses[i + 1][j] += remain / 2;
                    glasses[i + 1][j + 1] += remain / 2; 
                }
            }
        }
        return Math.min(glasses[query_row][query_glass], 1.0); //注意可能有剩余的，取1.0
    }
}
