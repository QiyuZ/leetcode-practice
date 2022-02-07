class Solution {
    public boolean validPalindrome(String s) { //refer 1216. Valid Palindrome III what if k?
        if (s == null || s.length() == 0) return true;
        int start = 0, end = s.length() - 1;
        while (start <= end && s.charAt(start) == s.charAt(end)) {
            start++;
            end--;
        }
        if (start > end) return true;
        if (isPalin(s, start + 1, end) || isPalin(s, start, end - 1)) return true;//because we can only remove one. So either the left or right one.
        return false;
    }
    public boolean isPalin(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }
}
