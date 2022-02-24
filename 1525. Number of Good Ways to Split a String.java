class Solution {
    public int numSplits(String s) {
        if (s == null || s.length() < 2) return 0;
        int[] right = new int[26], left = new int[26];
        int countLeft = 0, countRight = 0, res = 0;
        for (char c : s.toCharArray()) {
            if (right[c - 'a']++ == 0) countRight++;
        }
        for (char c : s.toCharArray()) {
            if (--right[c - 'a'] == 0) countRight--;
            if (left[c - 'a']++ == 0) countLeft++;
            if (countLeft == countRight) res++;
            if (countLeft > countRight) break; //dont need to continue as they can't be equal
        }
        return res;
    }
}
