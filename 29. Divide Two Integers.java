class Solution {
    public int divide(int dividend, int divisor) {
        if ((dividend == Integer.MAX_VALUE && divisor == 1) || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
        if ((dividend == Integer.MAX_VALUE && divisor == -1) || (dividend == Integer.MIN_VALUE && divisor == 1)) return Integer.MIN_VALUE;
        boolean flag = true;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) flag = false; //这里不能乘法判断，会过界，或者先long
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor); //注意这里要long,因为-2^31 abs后过界又变成了负数
        long res = 0;
        while (b <= a) { //这里是防止最后c过大停止运算，但实际上还剩一些可以除以，比如42/2最后c可能到了32而42只剩4.但其实还可以-2
            long c = b;
            for (int i = 0; c <= a; i++) { 
                a -= c;
                res += Math.pow(2, i);
                c *= 2; 
            }
        }
        return flag ? (int)res : (int)res * -1;
    }
}
/*如果一次一次减一个太慢，思路是比如42/2 第一次42-2， res+2^0;
第二次减去4， res+2^1
这样递增的减去，而结果则是递增的加上
