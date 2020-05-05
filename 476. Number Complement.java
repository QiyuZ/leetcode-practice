class Solution {
    public int findComplement(int num) { //找满位-num
        long x = 1; //小心边界值是max
        while (x <= num) x *= 2; //比如5=101 这步操作找到1000,比num的满位多1
        return (int)x - 1 - num; // x - 1 = 111  111-101 = final res
    }
}
