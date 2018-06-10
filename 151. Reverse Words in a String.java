public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] words = s.split("\\s+"); //可能是多个空格
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (res.length() > 0) res.append(" ");
            res.append(words[i]);
        }
        return res.toString().trim(); //去掉可能有点空格
    }
}
