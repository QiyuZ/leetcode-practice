class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; //since it's from 1 to n，abs因为可能之前为了记录visited变成了负数
            if (nums[index] > 0) nums[index] *= -1; //mark as visited, since it cannot be negative
            else res.add(Math.abs(nums[i])); //means it had been visited before注意是nums[i]因为是以它为index的
        }
        return res;
    }
}

