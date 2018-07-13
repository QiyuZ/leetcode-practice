class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (ratings == null || n == 0) return 0;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 1; i < n; i++) { //正反各检查一遍
            if (ratings[i] > ratings[i - 1]) res[i] = res[i - 1] + 1; //后面的大就在前面基础上+1
        }
        int sum = res[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) res[i] = Math.max(res[i], res[i + 1] + 1); //注意这点可能原来的比较大，就不用在小的基础上+1了
            sum += res[i];
        }
        return sum;
    }
}
