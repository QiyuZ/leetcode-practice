//DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i < res.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (res[j] == true && wordDict.contains(s.substring(j, i))) res[i] = true;
            }
        }
        return res[res.length - 1];
    }
}
