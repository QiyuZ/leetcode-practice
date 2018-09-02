
// O(n2)
// public class Solution {
//     public boolean checkSubarraySum(int[] nums, int k) {
//         if (nums == null || nums.length == 0)   return false;
//         int[] preSum = new int[nums.length + 1];
//         for (int i = 1; i <= nums.length; i++) preSum[i] = preSum[i-1] + nums[i-1];
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = i + 2; j <= nums.length; j++) {
//                 if (k == 0 && preSum[j] - preSum[i] == 0) return true; //此处注意判断k是否为0
//                 else if (k != 0 && (preSum[j] - preSum[i]) % k == 0) return true;
//             }
//         }
//         return false;
//     }
// }

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0)   return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) return true;
            }
            else map.put(sum, i);
        }
        return false;
    }
}
/*思路：放进去的其实是余数，A B C，如果A和A+B+C余数相同则说明B+C是这个数的倍数
A = m * k + r
A + B + C = n * k + r
B + C = (n - m) * k */
