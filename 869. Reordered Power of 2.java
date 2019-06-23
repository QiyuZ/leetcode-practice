class Solution {
    public boolean reorderedPowerOf2(int N) {
        if (N == 1) return true;
        long c = count(N);
        for (int i = 0; i < 33; i++) {
            if (count((1 << i)) == c) return true;
        }
        return false;
    }
    
    private long count(int num) { //相当于一个hash, 比如46就是表达为1001000，因为2的pow只有32个唯一的数字，然后挨个排查1<<32的hash是不是相同的
        long res = 0;
        for (; num > 0; num /= 10) {
            res += Math.pow(10, num % 10);
        }
        return res;
    }
}
