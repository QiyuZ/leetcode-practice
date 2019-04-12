class Solution {
    public int findMinStep(String board, String hand) {
        if (board == null || board.length() == 0) return 0;
        int[] count = new int[128];
        for (char c : hand.toCharArray()) count[c]++;
        return helper(board, count);
    }
    
    private int helper(String s, int[] count) {
        if ("".equals(s)) return 0;
        int res = 2 * s.length() + 1; //假设每个都是单个则要length*2， 所以+1为不可能达到的
        for (int i = 0; i < s.length();) {
            int j = i++; //赋值j一样位置然后i后移
            while (i < s.length() && s.charAt(i) == s.charAt(j)) i++; //此时i到达下一个不一样字母的位置，其实也是下一轮开始的头
            int need = 3 - i + j; //需要加入几个
            if (count[s.charAt(j)] >= need) { //如果满足有那么多个数，加入的话计算结果
                int used = need <= 0 ? 0 : need; //注意可能不需要加
                count[s.charAt(j)] -= used;
                int remain = helper(s.substring(0, j) + s.substring(i), count); 
                if (remain >= 0) res = Math.min(res, remain + used);
                count[s.charAt(j)] += used; //还原
            }
        }
        return res == 2 * s.length() + 1 ? -1 : res;
    }
}
