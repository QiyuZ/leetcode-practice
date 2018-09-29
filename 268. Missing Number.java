class Solution {
    public int missingNumber(int[] nums) {
        int sum = nums.length * (nums.length + 1) / 2;
        for (int num : nums) sum -= num;
        return sum;
    }
}

//如果是sorted的数组，在nlogn的时间做出
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) return 0; //只有一个元素是[0], [1]二分无法解决要提前考虑检查头尾
        if (nums[nums.length -1] != nums.length) return nums.length;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid) l = mid + 1; //相等说明左边没问题找右边
            else if (nums[mid] > mid) r = mid; //element > index说明左边不对， 不会出现nums[mid] < mid，因为少一个
        }
        return l; //最后停住的地方就是缺少的
    }
}
