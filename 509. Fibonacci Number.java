class Solution {
    public int fib(int N) {
        if (N <= 1) return N;
        return fib(N - 1) + fib(N - 2);
    }
}

class Solution {
    public int fib(int N) {
        if (N <= 1) return N;
        int a = 0, b = 1;
        while (N > 1) {
            N--;
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
