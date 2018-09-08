class Solution {
    private String[] words = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        comb("", res, digits, 0);
        return res;
    }
    public void comb(String cur, List<String> res, String digits, int index) {
        if (index == digits.length()) {
            res.add(cur);
            return;
        }
        int pos = Integer.parseInt(digits.charAt(index) + "");
        for (int i = 0; i < words[pos].length(); i++) { //23
            int curLen = cur.length();
            cur += words[pos].charAt(i);
            comb(cur, res, digits, index + 1); 
            cur = cur.substring(0, curLen); //一定要把cur再变回来
            //更简单的不用改变cur comb(cur + words[pos].charAt(i), res, digits, index + 1);, 这样cur没变，回溯时不会影响
        }
    }
}
