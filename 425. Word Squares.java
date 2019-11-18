class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words.length == 0 || words[0].length() == 0) return res;
        Map<String, Set<String>> map = new HashMap<>();
        map.put("", new HashSet<>());
        for (String w : words) {
            map.get("").add(w); //空字符串放入全部word初始化时考虑全部
            for (int i = 0; i < w.length(); i++) {
                map.putIfAbsent(w.substring(0, i + 1), new HashSet<>()); 
                map.get(w.substring(0, i + 1)).add(w); //prefix - word
            }
        }
        helper(res, new ArrayList<>(), 0, words[0].length(), map);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> cur, int matched, int len, Map<String, Set<String>> map) {
        if (matched == len) { //说明全部匹配
            res.add(new ArrayList<>(cur));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matched; i++) {
            sb.append(cur.get(i).charAt(matched));
        }
        Set<String> cand = map.get(sb.toString());
        if (cand == null) return;
        for (String word : cand) {
            cur.add(word);
            helper(res, cur, matched + 1, len, map);
            cur.remove(cur.size() - 1);
        }
    }
}

//斜轴对称的，比如先放进去 wall 那么取出a,找到area放入，然后就得到le以此类推，如果没有就不成立，因为每次找到的前缀会放到下一行，所以不用重复检验，
//比如wall, area 找到le放到下一行，l正是wall的第一个l，e也是area的e所以不必担心前面的不对
