class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> nums = new ArrayList<>();
        for (int[] g : grid) {
            for (int num : g) nums.add(num);
        }
        Collections.sort(nums);
        int median = nums.get(nums.size() / 2); //let every one move to median will be the best way
        int operations = 0;
        for (int num : nums) {
            if (Math.abs(num - median) % x != 0) return -1;
            operations += Math.abs(num - median) / x;
        }
        return operations;
    }
}
