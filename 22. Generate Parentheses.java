class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) return res;
        helper(res, 0, 0, "", n);
        return res;
    }
    
    private void helper(List<String> res, int l, int r, String s, int n) {
        if (l == r && s.length() == 2 * n) {
            res.add(s);
            return;
        }
        if (l < n) helper(res, l + 1, r, s + "(", n);
        if (l > r) helper(res, l, r + 1, s + ")", n);
    }
}
