class Solution {
    public int preimageSizeFZF(int K) { //其实答案不是5就是0，比如一个5，就是5,6,7,8,9；
        long left = 0, right = 5L * (K + 1); //下限是0，上限是比K多一个5，注意用5L防止overflow
        while (left < right) {
            long mid = left + (right - left) / 2;
            int count = countZeroAtTail(mid);
            if (count == K) return 5;
            if (count < K) left = mid + 1;
            else right = mid;
        }
        return 0;
    }
    
    private int countZeroAtTail(long x) { //leetcode 172, 阶乘有几个0和有几个5有关系
        int res = 0;
        while (x > 0) {
            res += x / 5; //加上这次的5
            x /= 5; //寻找下次的5
        }
        return res;
    }
}
