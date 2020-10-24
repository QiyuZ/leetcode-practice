class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        int l = 0, r = tokens.length - 1, score = 0;
        Arrays.sort(tokens);
        while (l <= r) {
            if (P >= tokens[l]) { //能买的情况下优先买，增加score因为这是最终结果
                score++;
                P -= tokens[l++];
            } else if (score > 0 && tokens[r] > tokens[l]) P = P + tokens[r--] - tokens[l++];
            //如果不够买了，那么就用score换再买前面的，前提是power得是增加的即tokens[r] > tokens[l]，不然是亏的
            else break; //注意这一行是必要的因为没有cover所有情况，剩下的情况说明即买不了也换不了，退出
        }
        return score;
    }
}
