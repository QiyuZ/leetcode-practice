class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        while (n > 1) {
            if (n % 2 != 0) return false;
            n /= 2;
        }
        return true;
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0; //所有2的power都是开头一个1剩下都是0比如100，那么-1就全是1少开头以为（即0）所以可以判断100,011 的&
    }
}
