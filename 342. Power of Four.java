class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (Math.log(num) / Math.log(4)) % 1 == 0;//注意Math.log是以10为底数的要多一步变换
    }
}

//x=4^a, then a = log4X = (1/2)log2X 所以log2num一定是偶数(Math.log(num) / Math.log(2)) % 2 == 1, 或者更直接(Math.log(num) / Math.log(4)) % 1 == 0
//同理power of 3就可以(Math.log10(n) / Math.log10(3) % 1 == 0, 其他数字一样道理
