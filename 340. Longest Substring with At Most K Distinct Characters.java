//sliding window
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int[] record = new int[256];
        int res = 0, num = 0, i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (record[s.charAt(j)]++ == 0) num++;
            if (num > k) {//其实就是到k+1时
                while (--record[s.charAt(i)] > 0) i++;
                //从前向后一个个移除，如果--还是大于0说明这个字母在窗口中还有就往后移下一个比如eceb走到b移走第一个e还要去移c
                i++; //跳到下一个有效字符上
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
//滑动窗口方法，头指针先走到超过k的地方尾指针一步步移动看什么时候符合k，保持一个窗口大小为k各不同字符的长度，同时每一步计算长度比较
