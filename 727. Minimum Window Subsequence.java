class Solution {
    public String minWindow(String S, String T) {
        int[][] M = new int[S.length()][T.length()];
        for(int i = 0; i < S.length(); i ++){
            if(S.charAt(i) == T.charAt(0)){
                M[i][0] = i;        //  largest starting index matches only first char in T
            }else{
                if(i == 0){
                    M[i][0] = -1;    // S, T both have 1 char, if !match, fill -1 means we can't find a substring for S(0) & T(0)
                }else{
                    M[i][0] = M[i - 1][0];
                }
            }
        }
        for(int j = 1; j < T.length(); j ++){
            for(int i = 0; i < S.length(); i ++){
                if(S.charAt(i) == T.charAt(j)){
                    if(i == 0){
                        M[i][j] = -1;       //  Actually, if j > i, M[i][j] is always -1, cause we cant find a substring of a shorter string matches a longer string
                    }else{
                        M[i][j] = M[i - 1][j - 1];  // As share2017 mentioned in his post
                    }
                }else{
                    if(i == 0){
                        M[i][j] = -1;      
                    }else{
                        M[i][j] = M[i - 1][j];  
                    }
                }
            }
        }
        int start = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < S.length(); i ++){
            if(M[i][T.length() - 1] != -1){
                if(i - M[i][T.length() - 1] + 1 < len){
                    len = i - M[i][T.length() - 1] + 1;
                    start = M[i][T.length() - 1];
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : S.substring(start, start + len);
    }
}

class Solution {
    public String minWindow(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int i = 0;
        int j = 0;
        int minL = Integer.MAX_VALUE;
        int start = -1;
        while (i < s.length) {
            if (s[i] == t[j]) {
                j++;
                if (j == t.length) {
                    int end = i;
                    j--;
                    while (j >= 0) {
                        if (s[i] == t[j]) {
                            j--;
                        }
                        i--;
                    }
                    if (end - i < minL) {
                        minL = end - i;
                        start = i + 1;
                    }
                    i++;
                    j = 0;
                }
            }
            i++;
        }
        return start == -1? "" : S.substring(start, start + minL);
    }
}
