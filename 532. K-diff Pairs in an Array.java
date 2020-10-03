class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int res = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);
            if ((k == 0 && map.get(key) > 1) || (k > 0 && map.containsKey(k + key))) res++; 
            //k=0则看有无重复的，只算一次，1,1,1算一个
            //k>0则看有没有下一个数，不用看-k的防止重复，当走到小的数的时候自然会找大的数
        }
        return res;
    }
}

class Solution {
    public int findPairs(int[] nums, int k) {
        // edge case
        if(nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int i = 0, j = 1, res = 0;
        while(i < nums.length && j < nums.length) {
            int diff = nums[j] - nums[i];
            if(i == j || diff < k) {
                j++;
            } else if(diff > k) {
                i++;
            } else {
                res += 1; 
                while(i+1 < nums.length && nums[i]==nums[i+1]) {
                    i++;
                }
                while(j+1 < nums.length && nums[j]==nums[j+1]) {
                    j++;
                }
                i++;
                j++;
            }
        }
        return res;
    }
}
