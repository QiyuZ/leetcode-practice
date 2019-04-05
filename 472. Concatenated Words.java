class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        if (words == null || words.length == 0) return res;
        Arrays.sort(words, (a, b) -> (a.length() - b.length())); //小的是用来组成的，要放在前面
        for (String word : words) {
            if (canForm(preWords, word)) res.add(word);
            preWords.add(word);
        }
        return res;
    }
    
    private boolean canForm(Set<String> preWords, String word) {
        if (preWords.isEmpty()) return false;
        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (!dp[j]) continue; //只有这个之前也是true才行
                if (preWords.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()]; //只要最后一个是true说明前面至少有一个true(至少有两个单词拼成)
    }
}
