class Solution {
    public int maxDepth(String s) {
        if (s == null || s.length() < 2) return 0;
        int count = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') max = Math.max(++count, max);
            else if (s.charAt(i) == ')') count--;
        }
        return max;
    }
}
