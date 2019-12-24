class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S == null || K > S.length() || K > 26) return 0;
        int[] mark = new int[26];
        int res = 0, i = 0;
        for (int j = 0; j < S.length(); ++j) {
            while (mark[S.charAt(j) - 'a'] > 0) mark[S.charAt(i++) - 'a']--;//说明j位字符不可用，移动i直到可以用
            mark[S.charAt(j) - 'a']++; //使用j位字符
            res += j - i + 1 >= K ? 1 : 0; 
            //此处是大于等于因为比如K=3 abcdef 有四个，虽然长度增大因为前面的还没有舍弃，但是每次会增加一个K 长度的substring
        }
        return res;
    }
}
