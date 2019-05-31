class Solution {
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String w : words) {
            int i = 0, j = 0;
            if (w.length() > S.length()) continue; //corner cases
            if (w.equals(S)) {
                res++;
                continue;
            }
            for (; i < S.length() ; i++) { //注意这里不应该限制j<w.length，比如hello最后那个o相等就停止了但是对于helllooo还没结束
                if (j < w.length() && S.charAt(i) == w.charAt(j)) j++;
                else if (i > 0 && S.charAt(i - 1) == S.charAt(i) && i < S.length() - 1 && S.charAt(i + 1) == S.charAt(i)) i++; //在第二位
                else if (!(i > 1 && S.charAt(i - 2) == S.charAt(i - 1) && S.charAt(i - 1) == S.charAt(i))) break;
                //只要不相等而且没有三个一组，肯定不match
            }
            if (i == S.length() && j == w.length()) res++;
        }
        return res;
    }
}


