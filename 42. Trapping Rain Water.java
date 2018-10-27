class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int l = 0, r = height.length - 1, res = 0;
        while (l < height.length - 1 && height[l + 1] > height[l]) l++; //先找到两边的边缘，上升的不能trap所以找开始上升的最后一个
        while (r > 1 && height[r - 1] > height[r]) r--;
        while (l < r) {
            int lVal = height[l], rVal = height[r];
            if (lVal < rVal) { //短边决定蓄水量，所以找短边移动计算
                while (l < r && lVal > height[++l]) res += lVal - height[l];
            } else {
                while (l < r && rVal > height[--r]) res += rVal - height[r];
            }
        }
        return res;
    }
}
