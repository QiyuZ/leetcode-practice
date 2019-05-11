class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] letter = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) letter[c- 'a']++;
        }
        Arrays.sort(words, (String a, String b) -> a.length() - b.length());
        for (String word : words) {
            if (helper(letter.clone(), word)) return word;
        }
        return "";
    }
    public boolean helper(int[] letter, String word) {
        for (char c : word.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) letter[c - 'a']--;
        }
        for (int l : letter) {
            if (l > 0) return false;
        }
        return true;
    }
}
