class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int right = (int)Math.sqrt(c), left = 0;
        while (left <= right) { //因为变成right其实是减小了点，所以可以等于
            int sum = right * right + left * left;
            if (sum == c) return true;
            else if (sum < c) left++;
            else right--;
        }
        return false;
    }
}
