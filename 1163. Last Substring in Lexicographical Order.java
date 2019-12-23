class Solution {
    public String lastSubstring(String s) {
        int i = 0, j = 1, offset = 0, len = s.length();
        if (s == null || s.length() == 0) return s;
        while (i + offset < len && j + offset < len) {
            char c1 = s.charAt(i + offset), c2 = s.charAt(j + offset);
            if (c1 == c2) offset++;
            else {
                if (c1 < c2) i = i + offset + 1; //因为之前遍历的都相等，所以中间的不用再遍历
                else j = j + offset + 1;
                if (i == j) j++;
                offset = 0;
            }
        }
        return s.substring(Math.min(i, j));
    }
}
