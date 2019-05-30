class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int sum = 0, line = 1;
        for (int i = 0; i < S.length(); i++) {
            if (sum + widths[S.charAt(i) - 'a'] > 100) {
                line++;
                sum = 0;
            } 
            sum += widths[S.charAt(i) - 'a'];
        }
        return new int[] {line, sum};
    }
}
