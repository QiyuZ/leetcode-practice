class Solution {
    public boolean detectCapitalUse(String word) {
        boolean allCap = true, allLower = true;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (cur >= 'a' && cur <= 'z') allCap = false;
            if (i != 0 && cur >= 'A' && cur <= 'Z') allLower = false;
        }
        return allCap || allLower;
    }
}
