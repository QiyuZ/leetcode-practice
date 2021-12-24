class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char wc = word.charAt(i), ac = abbr.charAt(j);
            if (wc == ac) {
                i++;
                j++;
                continue;
            }
            if (ac == '0') return false;
            int num = ac - '0';
            while (j + 1 < abbr.length() && Character.isDigit(abbr.charAt(j + 1))) {
                num = num * 10 + (abbr.charAt(j + 1) - '0');
                j++;
            }
            i += num - 1; // move to the last char which maps the number
            i++;
            j++; //be careful that here, i and j needs to move to the next one
        }
        return i == word.length() && j == abbr.length();
    }
}
