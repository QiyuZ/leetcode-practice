class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        int low = Integer.MIN_VALUE, i = -1;
        for (int num : preorder) {
            if (num < low) return false;
            while (i >= 0 && num > preorder[i]) low = preorder[i--];
            preorder[++i] = num;
        }
        return true;
    }
}
class Solution {
    public boolean verifyPreorder(int[] preorder) { //注意一个数组可能有多个答案，所以有一组成立即可
        if (preorder == null || preorder.length == 0) return true;
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack();
        for (int p : preorder) {
            if (p < low) return false;
            while (!path.empty() && p > path.peek()) low = path.pop(); //切换到root作为最小，因为出现比它大的就是到了右子树了
            path.push(p);
        }
        return true;
    }
}
