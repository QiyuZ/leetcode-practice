class Solution {
    public boolean backspaceCompare(String S, String T) {
        if (S.equals(T)) return true;
        int i = S.length() - 1, j = T.length() - 1, skipi = 0, skipj = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipi++;
                    i--;  //注意要每个block里面-1
                } else if (skipi > 0) {
                    skipi--;
                    i--;
                } else break; //要break否则出不来
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipj++;
                    j--;
                } else if (skipj > 0) {
                    skipj--;
                    j--;
                } else break;
            }
            if (i == -1 && j == -1) return true; //最终状态
            if (i == -1 || j == -1) return false;
            if (S.charAt(i) != T.charAt(j)) return false;
            i--;
            j--;
        }
        return true;
    }
}
