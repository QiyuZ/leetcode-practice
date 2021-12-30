class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome == null || palindrome.length() < 2) return "";
        for (int i = 0; i < palindrome.length() / 2; ++i) { //just need to iterate half of it
            if (palindrome.charAt(i) != 'a') return palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
        }
        return palindrome.substring(0, palindrome.length() - 1) + "b"; 
        //otherwise set b, because it's the palindrome, if the last one is "b", then the first one should be b and returns before
    }
}
