class Solution {
    public String decodeAtIndex(String S, int K) {
        char pre = 0; //这个的目的是数字前一个正好是，要记录上一个char
        long len = 0;
        for (char cur : S.toCharArray()) {
            if (Character.isLetter(cur)) {
                if (++len == K) return cur + ""; //是字母len肯定要+，如果正好是K就返回
                pre = cur;
            } else {
                long curLen = len * (cur - '0');
                if (curLen == K) return pre + "";//加上循环长度相等，就是之前那个
                else if (curLen > K) {
                    if (K % len == 0) return pre + ""; 
                    return decodeAtIndex(S, (int) (K % len)); //其实就是更新K，比如ha22 在这里len=4又循环2次，可得出K那么就求余数
                }
                len = curLen; //K 还比当前长度长，就接着move
            }
        }
        return "";
    }
}

class Solution {
    public String decodeAtIndex(String S, int K) {
        long N = 0L;
        int i;
        char[] chs = S.toCharArray();
        for (i = 0; N < K; i++) N = chs[i] >= '0' && chs[i] <= '9' ? N * (chs[i] - '0') : N + 1;
        i--;
        while (true){
            if (chs[i] >= '0' && chs[i] <= '9') {
                N /= chs[i] - '0';
                K %= N;
            } else if (K % N == 0) return "" + chs[i];
            else N--;
            i--;
        }
    }
}
