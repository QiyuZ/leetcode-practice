public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) count += (n >> i) & 1;//1011&0001 -> 101&001 -> 10&01 -> 1&1注意是向右移从后往前比较，而1只有最后一位有1所以比较最后一位
        return count;
    }
}
