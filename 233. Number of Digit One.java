class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        long left, right, base = 1;
        while (n >= base) {
            left = n / base;
            right = n % base;
            if ((left % 10) > 1) res += ((left / 10) + 1) * base;
            else if ((left % 10) == 1) res += (left / 10) * base + right + 1;
            else  
                res += (left / 10) * base;  //说明0结尾的没有right
            base *= 10;
        }
        return res;
    }
}

/* 逐个求每一位1的个数
left, right进行划分
比如54215 求百位的1个数。从541XX, 531XX到100，一共有55*100 个，这就是分left,right的作用，base不断翻10对应不同位数
