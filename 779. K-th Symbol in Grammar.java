class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        int pre = kthGrammar(N - 1, (K + 1) / 2); //因为每次翻倍，所以下一个的第一个相当于上一个第一个中的，而且是从1开始，所以+1
        if (pre == 0) return K % 2 == 0 ? 1 : 0; //上一个是0，那么如果K是偶数则是拓展出来的，要换
        else return K % 2 == 0 ? 0 : 1; //是1就是本身的，偶数不变
    }
}
