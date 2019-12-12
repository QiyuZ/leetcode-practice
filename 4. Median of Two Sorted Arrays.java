class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { //相当于找中间的数，二分k每次排除K/2知道k=1找到那个数
        int m = nums1.length, n = nums2.length;
        int left = (m + n + 1) / 2; //如果是偶数个则是两个，奇数则相同，不管什么情况+1不影响
        int right = (m + n + 2) / 2;
        return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;
    }
    
    private int getKth(int[] nums1, int s1, int e1, int[] nums2, int s2, int e2, int k) {
        int len1 = e1 - s1 + 1, len2 = e2 - s2 + 1;
        if (len1 > len2) return getKth(nums2, s2, e2, nums1, s1, e1, k); //保证nums1一直是短的，这样减少情况判断
        if (len1 <= 0) return nums2[s2 + k - 1]; //nums1走完了直接取nums2的
        if (k == 1) return Math.min(nums1[s1], nums2[s2]); //到了1，只需比较最小的那个
        int i = s1 + Math.min(len1, k / 2) - 1; //二分K 注意要比较是否越界
        int j = s2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) return getKth(nums1, s1, e1, nums2, j + 1, e2, k - (j - s2 + 1)); //定位小的那个，排除前面那些数字更新start和K
        return getKth(nums1, i + 1, e1, nums2, s2, e2, k - (i - s1 + 1));
    }
}
