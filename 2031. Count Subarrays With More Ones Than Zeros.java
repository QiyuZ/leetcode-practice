class Solution { //O(n^2) TLE
    private static final int mod = 1000000007;
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, sum = 0;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum += (nums[i - 1] == 0 ? -1 : 1);
            preSum[i] = sum;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (preSum[i] - preSum[j - 1] > 0) res = (res + 1) % mod;
            }
        }
        return res;
    }
}


class Solution { //O(n)
    private static final int mod = 1000000007;
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); //presum - count
        map.put(0, 1);
		// cnt: cumulative number of new valid subarray ending at i
        int res = 0, cnt = 0, prefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
			    // update prefixSum  
                prefixSum++;
				// any subarray ending at i-1 and has sum = 0 will create a new valid subarray
                cnt += map.getOrDefault(prefixSum - 1, 0);
            } else {
			    // replace 0 with -1, then update prefixSum  
                prefixSum--;
				// any subarray ending at i-1 and has sum = 1 will become invalid.
                cnt -= map.getOrDefault(prefixSum, 0);
            }
            res = (res + cnt) % mod;
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        return res;
    }
}
