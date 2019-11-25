class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.equals("")) return s;
        int len = 0, start = -1, end = -1;
        for (int i = 0; i < s.length(); i++) {
            int odd = helper(s, i, i);
            int even = helper (s, i, i + 1);
            int max = Math.max(odd, even);
            if (max > len) {
                start = i - (max - 1) / 2; // -1是因为如果是even的会多减1， 比如aaaa i=1减完就是-1 了，提前-1后对于odd也不会影响因为3/2 == 2/2
                end = i + max / 2;
                len = max;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int helper(String s, int left, int right) {
        int i = left, j = right;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}

