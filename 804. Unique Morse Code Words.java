class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> res = new HashSet<>();
        for (String word : words) {
            String code = "";
            for (char letter : word.toCharArray()) code = code + morse[letter - 'a'];
            res.add(code);
        }
        return res.size();
    }
}
