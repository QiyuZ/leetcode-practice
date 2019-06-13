class Solution {
    public String shiftingLetters(String S, int[] shifts) {
        int sum = 0;
        char[] chars = S.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            sum = (sum + shifts[i]) % 26;
            chars[i] = (char)(((chars[i] - 'a' + sum) % 26) + 'a');
        }
        return new String(chars);
    }
}
