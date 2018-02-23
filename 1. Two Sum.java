class Solution {
    public int[] twoSum(int[] nums, int target) {
        int num1 = -1, num2 = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                num1 = map.get(diff);
                num2 = i;
            }
            map.put(nums[i], i);
        }
        return new int[] {num1, num2};
    }
}
