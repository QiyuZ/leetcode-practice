class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) { //从0开始，一共32位不能移32位要比较最后一位，所以<32
            int bitX = (x >> i) & 1, bitY = (y >> i) & 1;
            if (bitX != bitY) count++;
        }
        return count;
    }
}

class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >>i) & 1;
        }
        return count;
    }
}
