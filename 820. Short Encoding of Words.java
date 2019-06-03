class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b) -> (b.length() - a.length()));
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            if(sb.toString().indexOf(w + "#") == -1) sb.append(w + "#");
        }
        return sb.toString().length();                                              
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) set.add(word);
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int result = 0;
        for (String word : set) result += word.length() + 1;
        return result;
    }
}
