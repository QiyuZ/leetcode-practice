public class Solution {
    public String addBoldTag(String s, String[] dict) {
        if (s == null || s.length() == 0 || dict == null || dict.length == 0) return s;
        boolean[] bold = new boolean[s.length()];
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) end = Math.max(end, i + word.length());
            }
            bold[i] = end > i; //if i hasn't reached to the end, we mark the current pos as true
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (!bold[index]) {
                result.append(s.charAt(index++));
                continue;
            }
            int j = index;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>" + s.substring(index, j) + "</b>");
            index = j;
        }
        return result.toString();
    }
}
