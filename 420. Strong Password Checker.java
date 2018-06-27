class Solution {
    public int strongPasswordChecker(String s) {
        int low = 0, upp = 0, dig = 0;
        int[] count = new int[3];
        int rep = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c <= 'z' && c >= 'a') low |= 1;
            else if (c <= 'Z' && c >= 'A') upp |= 1;
            else if (c <= '9' && c >= '0') dig |= 1;
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) j++;
            int len = j - i;
            if (len >= 3) {
                count[len % 3]++;
                rep += len / 3;
            }   
            i = j;
        }
        int miss = 3 - (low + upp + dig);
        if (s.length() < 6) return Math.max(6 - s.length(), miss); //小于6返回缺失的或者不满足三个要求的个数
        if (s.length() <= 20) return Math.max(rep, miss); //小于20返回需要被替换的或者不满足条件的个数
        int del = s.length() - 20;
        int res = 0;
        if (del <= count[0]) res = del + Math.max(rep - del, miss); 
        else if (del <= count[1]) res = del + Math.max(rep - count[0] - (del - count[0]) / 2, miss); //尽量都变成3k+2的因为替换一个就行
        else res = del + Math.max(rep - count[0] - count[1] - (del - count[0] - 2 * count[1]) / 3, miss);
        return res;
    }
}
