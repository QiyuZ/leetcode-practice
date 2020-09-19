class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 9; i++) helper(i, 0, low, high, res); //不用9因为9不能再增了
        Collections.sort(res);
        return res;
    }
    
    private void helper(int start, int cur, int low, int high, List<Integer> res) {
        if (cur >= low && cur <= high) res.add(cur);
        if (start > 9 || cur > high) return;//start 只能1到9
        helper(start + 1, cur * 10 + start, low, high, res);
    }
}
