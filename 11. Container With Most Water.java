class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, res = 0;
        while (l < r) { 
            int temp = (r - l) * Math.min(height[l], height[r]);
            if (height[l] < height[r]) l++; //移走短板看看变化
            else r--;
            res = Math.max(res, temp);
        }
        return res;
    }
}
