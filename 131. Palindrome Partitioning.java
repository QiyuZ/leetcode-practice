class Solution {
    public List<List<String>> partition(String s) { //和combination一个思路，backtracking去找所有的
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(res, new ArrayList<String>(), s);
        return res;
    }
    public void helper(List<List<String>> res, List<String> cur, String s) {
        if (s.length() == 0) { //说明走到了头，所有的都成立
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalin(s.substring(0, i + 1))) {
                cur.add(s.substring(0, i + 1));
                helper(res, cur, s.substring(i + 1));
                cur.remove(cur.size() - 1); //别忘了去掉当前的
            }
        }
    }
    public boolean isPalin(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;

        }
        return true;
    }
}
