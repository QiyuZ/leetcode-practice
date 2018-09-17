class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length <= 1) return 0;
        return divideSort(nums, 0, nums.length - 1);//分治
    }
    public int divideSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int count = divideSort(nums, start, mid) + divideSort(nums, mid + 1, end);
        Arrays.sort(nums, start, mid + 1); //左右分别排序，虽然index顺序变了但是不影响，因为左边的一定比右边小
        Arrays.sort(nums, mid + 1, end + 1); //注意 toindex 不包含本位要多一个
        int l = start, r = mid + 1;
        while (l <= mid && r <= end) {
            if ((long)nums[l] > (long)2 * nums[r]) { //防止overflow
                count += mid - l + 1; //左边的一个可以，剩下的都可以
                r++; //跳到右边下一个数字
            }
            else l++; //不可以就继续
        }
        return count;
    }
}
