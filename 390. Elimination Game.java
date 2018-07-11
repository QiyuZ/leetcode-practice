class Solution {
    public int lastRemaining(int n) {
        int remaining = n, head = 1, step = 1; //remaining是剩下的个数，head是开头，step是head可能递增的个数
        boolean from_left = true; //先从左边开始删减
        while (remaining > 1) {
            if (from_left || remaining % 2 == 1)  head += step; //如果左边开始或者奇数个（不管哪边开始）第一个都会被删去，所以加上step
            remaining /= 2; //每次删掉一半，奇数个则删掉一半多一个
            step *= 2; //因为删掉一半所以翻倍，比如例子，1,2,4变化（2的时候没删掉head但是要记录这个变化）
            from_left = !from_left; //记录方向
        }
        return head;
    }
}
