class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return "";
        int[] record = new int[128];
        for (char c : t.toCharArray()) record[c]++;
        int right = 0, left = 0, head = 0, count = 0, diff = s.length() + 1;
        while (right < s.length()) { //移动窗口，找到全包含，然后左边再右移
            if (record[s.charAt(right++)]-- > 0) count++; //这个还有下面要注意，无论如何都要++或--这样才会有相对的不同
            while (count == t.length()) {
                if (diff > right - left) {
                    diff = right - left;
                    head = left;
                }
                if (record[s.charAt(left++)]++ == 0) count--; //这个count够了，找下一个count够了的情况，再比较大小
            }
        }
        return diff <= s.length() ? s.substring(head, head + diff) : "";
    }
}
