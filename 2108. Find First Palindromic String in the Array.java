class Solution {
    public String firstPalindrome(String[] words) {
        if (words == null || words.length == 0) return "";
        for (String word : words) {
            if (isPalindrom(word)) return word;
        }
        return "";
    }
    
    private boolean isPalindrom(String word) {
        if (word.length() == 1) return true;
        int l = 0, r = word.length() - 1;
        while (l <= r) {
            if (word.charAt(l) == word.charAt(r)) {
                l++;
                r--;
            } else return false;
        }
        return l >= r;
    }
}
