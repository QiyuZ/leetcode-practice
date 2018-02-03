class Solution {
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                high++;
                low++;
            } else if (c == ')') {
                if (low > 0) low--;
                high--;
            } else if (c == '*') {
                if (low > 0) low--;
                high++;
            }
            if (high < 0) return false;
        }
        return low == 0;
    }
}
//其中low表示在有左括号的情况下，将星号当作右括号时括号的相对个数(这样做的原因是尽量不多增加右括号的个数)，
//而high表示将星号当作左括号时括号的相对个数。
