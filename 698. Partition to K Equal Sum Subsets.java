class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        Arrays.sort(nums); //sort, then scan from tail which is easy to stop
        for (int num : nums) sum += num;
        if (sum % k != 0 || k > sum) return false; //can't get int avg or k > sum, false
        sum /= k;
        boolean[] visited = new boolean[nums.length];
        return helper(nums, visited, sum, 0, nums.length - 1, k); //scan from tail to head
    }
    
    public boolean helper(int[] nums, boolean[] visited, int target, int curSum, int index, int k) {
        if (k == 1) return true; //1 is OK, because if only one left and we have known we can get int avg, then it must exist 
        if (curSum == target) return helper(nums, visited, target, 0, nums.length - 1, k - 1);
        for (int i = index; i >= 0; i--) {
            if (!visited[i] && curSum + nums[i] <= target) { //add "curSum + nums[i] <= target" to avoid unecessary calculate
                visited[i] = true;
                if (helper(nums, visited, target, curSum + nums[i], i - 1, k)) return true;
                visited[i] = false;
            }
        }
        return false;
    }
}
