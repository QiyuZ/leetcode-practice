class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (mid % 2 == 1) mid--; //第一个数总是在偶数位，先把指针放到第一个数
            if (nums[mid] != nums[mid + 1]) r = mid; //后面不相等说明前面少了（因为其实是第二个数）
            else l = mid + 2; //注意此处用+2移动到下一个第一个位置
        }
        return nums[l];
    }
}
