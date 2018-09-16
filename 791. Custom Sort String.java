class Solution {
    public String customSortString(String S, String T) { //O(T)
        if (T == null || T.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int[] letters = new int[26];
        for (int i = 0; i < T.length(); i++) letters[T.charAt(i) - 'a']++;
        for (int i = 0; i < S.length(); i++) {
            while (letters[S.charAt(i) - 'a'] > 0) {
                sb.append(S.charAt(i));
                letters[S.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (letters[i] > 0) {
                sb.append((char)(i + 'a'));
                letters[i]--;
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String customSortString(String S, String T) { //O(ST)
        if (T == null || T.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int[] letters = new int[26];
        for (int i = 0; i < T.length(); i++) letters[T.charAt(i) - 'a']++;
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            for (int j = 0; j < T.length(); j++) {
                if (cur == T.charAt(j)) {
                    sb.append(cur);
                    letters[T.charAt(j) - 'a']--;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            while (letters[i] > 0) {
                sb.append((char)(i + 'a'));
                letters[i]--;
            }
        }
        return sb.toString();
    }
}
