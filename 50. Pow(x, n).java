class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        long count = n > 0 ? n : -(long)n;
        double res = 1;
        while (count != 0) {
            if (count % 2 == 1) res *= x; //乘上奇数多余的x
            x *= x;  //偶数个时，先让x自己累乘，后面再一起乘上
            count /= 2;
        }
        return n > 0 ? res : 1.0 / res;
    }
}

//log(n)
