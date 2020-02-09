class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0], fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}


// class Solution {
//     public int findDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         for (int i = 0; i < nums.length - 1; i++) {
//             if (nums[i] == nums[i + 1]) return nums[i];
//         }
//         return -1;
//     }
// }
