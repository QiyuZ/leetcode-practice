class Solution {
    public int[] findPermutation(String s) {
        if (s == null || s.length() == 0) return new int[0];
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < res.length; i++) res[i] = i + 1;//因为要按顺序找最小的，无要求下就是1,2,3,4...
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (i < s.length() && s.charAt(i) == 'D') i++;//因为有D，所以找到下一个I交换这个区间内所有即符合区间下降要求
            reverse(res, j, i);
            i++;
        }
        return res;
    }
    
    private void reverse(int[] res, int left, int right) {
        while (left < right) {
            int temp = res[left];
            res[left++] = res[right];
            res[right--] = temp;
        }
    }
}
