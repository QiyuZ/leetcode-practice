class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for (String q : queries) {
            res.add(isMatch(q, pattern));
        }
        return res;
    }
    
    private boolean isMatch(String q, String pattern) {
        int i = 0;
        for (char c : q.toCharArray()) {
            if (i < pattern.length() && c == pattern.charAt(i)) i++;
            else if (c <= 'Z' && c >= 'A') return false; //大写的必须在pattern里面
        }
        return i == pattern.length(); //pattern里面如果有小写，会在这一步比较是否全部包含，因为插入可以在任何位置，所以只要相对顺序一样就可以
    }
}
