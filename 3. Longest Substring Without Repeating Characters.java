class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] mark = new boolean[256];
        int res = 0, pos = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (mark[cur]) {
                res = Math.max(res, i - pos);
                while (i > pos) {
                    if (cur == s.charAt(pos)) {
                        pos++; //注意这里不用变mark因为此时是多了这个字母
                        break;
                    }
                    mark[s.charAt(pos)] = false; //如果不是，变mark并且前指针后移一位
                    pos++;
                }
            }
            else mark[cur] = true;
        }
        return Math.max(res, s.length() - pos); //别忘了比较最后一位
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                pos = Math.max(pos, map.get(s.charAt(i)) + 1); //找到最靠后重复的那个
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - pos + 1);
        }
        return res;
    }
}
