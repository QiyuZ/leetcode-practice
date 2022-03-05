class Solution { //same as next Permutation
    public String nextPalindrome(String num) {
        String half = num.substring(0, num.length() / 2); //just consider half will be fine as it's palindrome
        char[] halfLetters = half.toCharArray();
        int i = half.length() - 2;
        while (i >= 0 && halfLetters[i] >= halfLetters[i + 1]) i--; //524321 find 2 
        if (i < 0) return "";
        int j = half.length() - 1;
        while (halfLetters[j] <= halfLetters[i]) j--; //find 3 and exchange -> 534221
        swap(halfLetters, i, j);
        reverse(halfLetters, i + 1, halfLetters.length - 1); //534221 isn't the final answer as the 4221 can revert -> 531224
        String left = new String(halfLetters);
        String right = new StringBuilder(left).reverse().toString();
        if (num.length() % 2 == 1) return left + num.charAt(num.length() / 2) + right; //note the string can be odd
        return left + right;
    }
    private void swap(char[] letters, int i, int j) {
        char temp = letters[i];
        letters[i] = letters[j];
        letters[j] = temp;
    }
    private void reverse(char[] letters, int i, int j) {
        while (i < j) swap(letters, i++, j--);
    }
}
