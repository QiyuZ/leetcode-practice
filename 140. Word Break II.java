class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        if (map.containsKey(s)) return map.get(s); //这一行是关键，不加会超时
        if (wordDict.contains(s)) res.add(s);
        for (int i = 0; i < s.length(); i++) {
            String t = s.substring(i);
            if (wordDict.contains(t)) {
                List<String> temp = wordBreak(s.substring(0, i), wordDict);
                if (temp.size() != 0) {
                    for (String str : temp) res.add(str + " " + t);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
//带有记忆的dfs
