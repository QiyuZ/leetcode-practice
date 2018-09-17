class Solution {
    public boolean backspaceCompare(String S, String T) { //O(1) time
        int i = S.length() - 1, j = T.length() - 1;
        int skipi = 0, skipj = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') { //先把#个数算出来，skip来减去前面的letter
                    skipi++;
                    i--;
                } else if (skipi > 0) {
                    i--;
                    skipi--;
                } else break; //最后停留在字母上
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') { //同理
                    skipj++;
                    j--;
                } else if (skipj > 0) {
                    j--;
                    skipj--;
                } else break;
            }
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false; //后面的能删除的都删了，当前不相等就肯定不行
            if ((i >= 0) != (j >= 0)) return false; //一个结束了，另一个没有，而且最后一位是字母，也肯定不相等了
            i--;
            j--;//移到下一位
        }
        return true;//能出来就是true因为最后可能-1，或者-2等
    }
}
