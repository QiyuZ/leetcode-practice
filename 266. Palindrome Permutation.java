class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) set.remove(c);
            else set.add(c);
        }
        return set.size() <= 1;
    }
}

class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int[] mark = new int[256];
        for (char c : s.toCharArray()) {
            mark[c]++;
        }
        int count = 0;
        for (int num : mark) {
            if (num % 2 != 0) count++;
        }
        return count <= 1;
    }
}
