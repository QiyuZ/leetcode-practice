class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {//maxSize没有用，因为如果aaba出现了4次，aab至少四次，所以要求范围内最短的
        Map<String, Integer> count = new HashMap<>();
        int[] mark = new int[26];
        int l = 0, letter = 0, res = 0;
        for (int r = 0; r < s.length(); r++) { //sliding window
            if (mark[s.charAt(r) - 'a']++ == 0) letter++; //等于0说明之前没有即字母加一，无论什么情况都要加mark
            while (letter > maxLetters || r - l + 1 > minSize) {//用while因为可能移除的是相同的字母，要看字母数和长度
                if (mark[s.charAt(l) - 'a'] == 1) letter--;//只有一个说明是最后一个，字母减一
                mark[s.charAt(l) - 'a']--;//无论什么情况都要mark-1 和移动l
                l++;
            }
            if (r - l + 1 == minSize) { //注意只考虑要求范围内最短的
                String sub = r == s.length() ?  s.substring(l) : s.substring(l, r + 1); 
                count.put(sub, count.getOrDefault(sub, 0) + 1);
                res = Math.max(res, count.get(sub));
            }
        }
        return res;
    }
}

