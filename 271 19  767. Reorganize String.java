class Solution {
    public String reorganizeString(String S) {
        if (S == null || S.length() < 2) return S;
        int[] mark = new int[26];
        int max = 0;
        char maxChar = 'a';
        for (char ch : S.toCharArray()) {
            mark[ch - 'a']++;
            if (mark[ch - 'a'] > max) {
                max = mark[ch - 'a'];
                maxChar = ch;
            }
        }
        if (2 * max > S.length() + 1) return ""; //最多的超过一半则不行,max个要至少有max-1个其他的，所以当n-max < max-1则不成立
        int i = 0;
        char[] res = new char[S.length()];
        while (mark[maxChar - 'a'] > 0) { //先把最多的放偶数位，已知肯定成立所以一定能放下
            res[i] = maxChar;
            mark[maxChar - 'a']--;
            i += 2;
        }
        for (int j = 0; j < 26; j++) {//这里注意之前偶数位不一定结束了，所以要直接走不能在之前就i=1
            while (mark[j] > 0){
                if (i >= S.length()) i = 1; //检查要在while循环里，因为随时可能走完，注意是>=因为不一定奇数偶数，可能停止len+1
                res[i] = (char)(j + 'a');
                mark[j]--;
                i += 2; //注意还是移两位
            } 
        }
        return new String(res);
    }
}
