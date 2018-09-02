class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num); //lower bound是其中最大的数
            right += num; //upper bound就是全部的和
        }
        if (m == 1) return right;
        if (m == nums.length) return left;
        while (left < right) {
            int mid  = left + (right - left) / 2;
            if (valid(nums, m, mid)) right = mid; //如果可行就缩小范围降低sum，不可行就提升left
            else left = mid + 1; //left一定存在，因为是一直逼近的
        }
        return left;
    }
    public boolean valid(int[] nums, int m, int sum) {
        int count = 1, cur = 0;
        for (int num : nums) {
            cur += num;
            if (cur > sum) { //超过预设最大值，则新开一组当前值算入新组（因为加上它就超了），之前的算一组
                count++;
                cur = num;
            }
            if (count > m) return false; //count<m没关系，说明可行但是sum设定过大，可以继续走；>m就分不出来了
        }
        return true;
    }
}

/* 1,2,3,4,5
left 5, right 15, mid=10 [1,2,3,4] [5] m=2
left=5, right=10, mid=7  [1,2,3] [4] [5] m=3
left=5, right=7, mid=6 [1,2,3] [4] [5] m=3
left=5, right=6, mid=5 [1,2] [3] [4] [5] m=4 -> left++ -> left > right -> quit  
return 6
*/
