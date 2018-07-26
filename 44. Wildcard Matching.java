class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 0, j = 1; j < match[0].length; j++) { //特殊情况，因为*可以为空所以提前过一下match[0][j], 举例abc, **abc
            if (p.charAt(j - 1) == '*') match[i][j] = true;
            else break;
        }

        for (int i = 1; i < match.length; i++) {
            for (int j = 1; j < match[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') match[i][j] = match[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') match[i][j] = (match[i][j - 1] || match[i - 1][j]);
                //match[i][j - 1] 把本位作为空位，match[i - 1][j]本位可以扩展成任何字符
            }
        }
        return match[s.length()][p.length()];
    }
}
