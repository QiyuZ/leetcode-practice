class Solution {
    public int maxSubarraySumCircular(int[] A) { 
        //case 1 最大子数组不用cycle，在中间， 53 Maximum Subarray 来做
        //case 2 最大子数组要用cycle， 算出最小子数组用总数减去它即可
        if (A == null || A.length == 0) return 0;
        int sumMax = 0, sumMin = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, total = 0;
        for (int a : A) {
            if (sumMax < 0) sumMax = a; //如果小于0，不管a是正或者负数，都是直接为a最大
            else sumMax += a;
            if (sumMin > 0) sumMin = a; //相反同理找最小
            else sumMin += a;
            max = Math.max(sumMax, max);//更新
            min = Math.min(sumMin, min);
            total += a;
        }
        return max > 0 ? Math.max(max, total - min) : max;
        //max大于0 考虑两种情况，<=0则说明所有的数全都小于等于0，这是min是全部数字的和total==min，只能选max
    }
}
