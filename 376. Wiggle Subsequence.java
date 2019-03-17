class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] diff = new int[nums.length - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }
        int pre = 0, count = 0;
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] > 0) {
                if (pre <= 0) count++;
                pre = 1;
            } else if (diff[i] < 0) {
                if (pre >= 0) count++;
                pre = -1;
            } 
        }
        return count + 1;
    }
}

/* 
只看有几个符合条件不管具体怎么删减， 比如第二个例子就是
16, -12, 5, 3, 2, -5, 11, -8
*/
