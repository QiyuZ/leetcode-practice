class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0 || s.length() == 0) return res;
        int n = words.length, m = words[0].length(); //题目中说了每个单词长度相等
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) map.put(str, map.getOrDefault(str, 0) + 1);
        for (int i = 0; i <= s.length() - n * m; i++) { //注意此处最后一个位置等于这些长度
            Map<String, Integer> copy = new HashMap<>(map);
            int k = n, j = i;
            while (k > 0) { //包含其中一个单词就往下走，知道能走到k=0说明所有单词都包含了
                String cur = s.substring(j, j + m);
                if (!copy.containsKey(cur) || copy.get(cur) < 1) break;
                copy.put(cur, copy.get(cur) - 1);
                k--;
                j += m;
            }
            if (k == 0) res.add(i);
        }
        return res;
    }
}
