class Solution {
    public int maximumSwap(int num) {
        int i = 1;
        String s = num + "";
        while (i < s.length() && s.charAt(i) <= s.charAt(i - 1)) i++;
        if (i == s.length()) return num;
        int max_pos = -1;
        char max = s.charAt(i);
        for (int j = i; j < s.length(); j++) { //find the largest one on the second part
            if (s.charAt(j) >= max) { //should use >= 要使得这个数尽量在后面（相等情况下）
                max = s.charAt(j);
                max_pos = j;
            }
        }
        for (int k = 0; k < i; k++) {
            if (s.charAt(k) < max) return swap(s, max_pos, k); //find the first one smaller than max
        }
        return num;
    }
    public int swap(String s, int l, int r) {
        char[] ch = s.toCharArray();
        char temp = ch[l];
        ch[l] = ch[r];
        ch[r] = temp;
        return Integer.parseInt(new String(ch));
    }
}

/* 不可以直接找最大或者最小值，因为可能不是交换这两个，比如 99836
所以分成两部分 前一部分下降的和后面的
在后面找到最大的，在前面找到第一个比它小的，然后交换
思考如下，首先找大的，前半部分递减的肯定没有，所以在后半部分中
找到了大的，一定会换靠前面的，所以找到第一个小于max的*/
