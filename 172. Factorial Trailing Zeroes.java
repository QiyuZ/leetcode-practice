class Solution {
    public int trailingZeroes(int n) {
        if (n < 5) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }
}

//2是充足的就看有几个5就行，一部分是那个数的因子有几个5，比如n=25,那么n/5=5是5,10,15,20,25；下面的5/5=1是25=5*5，是2个5，之前只算了一次
