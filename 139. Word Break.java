class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; //加个break有一个成立即可
                }
            }
        }
        return dp[dp.length - 1];
    }
}

public class Solution {
    private static int marked = 1;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0); //starts with index 0
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start] == marked) continue;
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if (end == s.length()) return true;
                }
            }
            visited[start] = 1;
        }
        return false;
    }
}

public class Solution {
    private Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new Boolean[s.length()];
        return wordBreakMemo(s, new HashSet<>(wordDict), 0);
    }
    private boolean wordBreakMemo(String s, Set<String> wordDict, int start) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }
}
