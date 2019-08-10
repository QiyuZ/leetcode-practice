class Solution {
    public int bagOfTokensScore(int[] tokens, int P) { //greedy，牺牲积分换大power，获得积分用较少的power
        if (tokens.length == 0) return 0;
        int left = 0, right = tokens.length - 1, points = 0, res = 0;
        Arrays.sort(tokens);
        while (left <= right) {
            if (P >= tokens[left]) { //左边在前面因为当left=right，游戏要结束优先考虑得分
                P -= tokens[left++];
                res = Math.max(res, ++points);
            } else if (points > 0) {
                P += tokens[right--];
                points--;
            } else break;
        }
        return res;
    }
}
