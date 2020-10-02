public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] words = s.split("\\s+"); //可能多个空格
        StringBuilder res = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            res.append(" "); 
        }
        return res.toString().trim();//因为如果前面有多个空格第一个元素会是“”，不一定有没有，所以要trim,防止有
    }
}
