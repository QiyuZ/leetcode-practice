class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || p == null) return res;
        int[] mark = new int[26];
        for (char c : p.toCharArray()) mark[c - 'a']++;
        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (mark[s.charAt(i) - 'a'] == 0) continue;
            int[] copy = mark.clone();
            for (int j = i; j < i + p.length(); j++) {
                copy[s.charAt(j) - 'a']--;
            }
            if (isClear(copy)) res.add(i);
        }
        return res;
    }
    private boolean isClear(int[] nums) {
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {//sliding window
        List<Integer> res = new ArrayList<>();
        if (s == null || s.isEmpty()) return res;
        int[] record = new int[256];
        for (char c : p.toCharArray()) record[c]++;
        int left = 0, right = 0, count = 0;
        while (right < s.length()) {
            if (record[s.charAt(right)] > 0) count++;//遇到target,count加
            record[s.charAt(right)]--;//无论什么情况都要变record和移动right指针
            right++;
            //注意此时right已经移动过，所以不用+1=p长度，right - left == p.length()可以不写，因为下面的每次会检查长度
            if (right - left == p.length() && count == p.length()) res.add(left);
            if (right - left == p.length()) { //只有超过长度的时候才移动left,使其一直保持p.length长度
                if (record[s.charAt(left)] >= 0) count--;
                record[s.charAt(left)]++;
                left++;
            }
        }
        return res;
    }
}
