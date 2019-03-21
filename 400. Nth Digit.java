class Solution {
    public int findNthDigit(int n) {
        int level = 1;
        long times = 9;
        while (n - level * times > 0) {
            n -= level * times;
            level++;
            times *= 10;
        }
        int base = (int)Math.pow(10, level - 1); //1, 10, 100 ...
        int num = (n - 1) / level + base;
        int index = (n - 1) % level;
        return String.valueOf(num).charAt(index) - '0';
    }
}
