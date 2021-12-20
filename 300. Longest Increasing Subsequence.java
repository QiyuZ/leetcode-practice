// n^2
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}


//nlogn  为什么可以用二分法呢？因为tails这个数组就是结果的数组，是有序的
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tails = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int l = 0, r = size, m = 0;
            while (l < r) {
                m = l + (r - l) / 2;
                if (tails[m] < num) l = m + 1;
                else r = m;
            }
            tails[l] = num;
            if (l == size) size++;  //如果一直移到了l=size那么说明有新加入的
        }
        return size;
    }
}

/**
*One thing to add: this algorithm does not always generate a valid subsequence of the input, but the length of the subsequence will always equal the length of the longest increasing subsequence. For example, with the input [3, 4, 5, 1], at the end we will have sub = [1, 4, 5], which isn't a subsequence, but the length is still correct. The length remains correct because the length only changes when a new element is larger than any element in the subsequence. In that case, the element is appended to the subsequence instead of replacing an existing element.
The purpose the replace is to ensure the following valid value could be appeneded
**/
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         List<Integer> res = new ArrayList<>();
//         res.add(nums[0]);
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] > res.get(res.size() - 1)) res.add(nums[i]);
//             else {
//                 int pos = 0;
//                 while (pos < res.size() && res.get(pos) < nums[i]) pos++;
//                 res.set(pos, nums[i]);
//             }
//         }
//         return res.size();
//     }
// }

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) sub.add(num);
            else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }
        return sub.size();
    }
    
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0, right = sub.size() - 1, mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) return mid;
            if (sub.get(mid) < num) left = mid + 1;
            else right = mid;
        }
        
        return left;
    }
}
