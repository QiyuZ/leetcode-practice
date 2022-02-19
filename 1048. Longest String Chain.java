class Solution {
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) return 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[words.length];
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (valid(words[j], words[i])) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    private boolean valid(String pre, String cur) {
        if (pre.length() >= cur.length() || cur.length() - pre.length() > 1) return false;
        int i = 0, j = 0;
        boolean found = false;
        while (i < pre.length() && j < cur.length()) {
            if (pre.charAt(i) == cur.charAt(j)) {
                i++;
                j++;
            } else {
                if (found) return false;
                found = true;
                j++;
            }
        }
        return true;
    }
}

class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>(); //word - len of seq
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); ++i) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }
}
