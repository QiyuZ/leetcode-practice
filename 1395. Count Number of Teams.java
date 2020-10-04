class Solution {
    public int numTeams(int[] rating) {
        if (rating == null || rating.length == 0) return 0;
        int res = 0;
        for (int i = 1; i < rating.length - 1; i++) { //不考虑两边因为把每个数作为中间数来对待，这样可以避免重复
            int[] less = new int[2], greater = new int[2]; //两位，都是左右含义即less[0] i 左边的小于rating[i]的
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) less[0]++;
                else if (rating[j] > rating[i]) greater[0]++;
            }
            for (int j = i + 1; j < rating.length; j++) {
                if (rating[j] < rating[i]) less[1]++;
                else if (rating[j] > rating[i]) greater[1]++;
            }
            res += less[0] * greater[1] + greater[0] * less[1]; //上升：左小-中-右大 + 下降：左大-中-右小
        }
        return res;
    }
}
