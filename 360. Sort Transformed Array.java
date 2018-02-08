class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int start = 0, end = nums.length - 1;
        int i = a >= 0 ? nums.length - 1 : 0; //a决定了元素是先放在开头还是结尾
        while (start <= end) {
            int startNum = getNum(nums[start], a, b, c);
            int endNum = getNum(nums[end], a, b, c);
            if (a >= 0) {   //a >= 0 则大的在两边然后比较一下左右放在最后
                if (startNum >= endNum) {
                    res[i--] = startNum;
                    start++;
                } else {
                    res[i--] = endNum;
                    end--;
                }
            } else { //a < 0 则小的在两边然后比较一下左右放在前面
                if (startNum <= endNum) {
                    res[i++] = startNum;
                    start++;
                } else {
                    res[i++] = endNum;
                    end--;
                }
            }
        }
        return res;
    }
    public int getNum(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
//利用抛物线特性，a>=0开口向上两边大中间小，双指针，反之；
