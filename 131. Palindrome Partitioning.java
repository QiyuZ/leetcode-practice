class Solution {//O(n*2^n)
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        dfs(res, new ArrayList<String>(), s, 0);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> cur, String s, int start) {
        if (start == s.length()) { //it's the end add all
            res.add(new ArrayList<>(cur));//copy list to avoid being changed
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalin(s, start, i)) {
                cur.add(s.substring(start, i + 1));
                dfs(res, cur, s, i + 1); //note here is i + 1, otherwise, it will stay the same pos forever
                cur.remove(cur.size() - 1);//move the last one, and find next valid ones, like[a,a,b,a] then back it will remove b and a and find[a, aba]
            }
        }
    }
    private boolean isPalin(String s, int l, int r) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return l >= r; //odd l==r, even l > r, well better just return false during process
    }
}
