class Solution {
    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++; //保证连续
            else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) res++;
        }
        return res;
    }
}

/*因为只有0,1，所以可用pre,cur交替代换，当pre >= cur，说明可以匹配一个,相当于找这个substring的结尾比如
    0 0 1 1 0
cur 1 2 1 2 1
pre 0 0 2 2 2
        1 2 3
*/
