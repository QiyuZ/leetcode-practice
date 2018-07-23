class Solution {
    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur >= 'A' && cur <= 'Z') sb.append((char)((cur - 'A') + 'a'));
            else sb.append(cur);
        }
        return sb.toString();
    }
}
