class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skip0 = 0, skip1 = 0;
        while (i >= 0 || j >= 0) { //每次都停到字母上或者到了-1,要包括0因为0也要继续比
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    i--;
                    skip0++;
                } else if (skip0 > 0) {
                    skip0--;
                    i--;
                } else break;
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    j--;
                    skip1++;
                } else if (skip1 > 0) {
                    skip1--;
                    j--;
                } else break;
            }
            if (i == -1 && j == -1) return true; //min index is -1
            if (i == -1 || j == -1) return false; 
            if (S.charAt(i) != T.charAt(j)) return false;
            i--;
            j--;
        }
        return true;
    }
}
