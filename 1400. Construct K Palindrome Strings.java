class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n == k) return true;
        if (n < k) return false;
        int[] records = new int[26];
        for (char c : s.toCharArray()) records[c - 'a']++;
        int count = 0;
        for (int num : records) count += num % 2;
        return count <= k;
    }
}
