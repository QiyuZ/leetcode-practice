class Solution { //actually same as 907, but iterate twice, one for -min, another for +max
    public long subArrayRanges(int[] A) {
        int n = A.length, j, k;
        long res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] > (i == n ? Integer.MIN_VALUE : A[i])) {
                int indexToCount = s.pop();
                int left = indexToCount - (s.isEmpty() ? -1 : s.peek());
                int right = i - indexToCount;
                res -= (long)A[indexToCount] * left * right;
            }
            s.push(i);  
        }
        s.clear();
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] < (i == n ? Integer.MAX_VALUE : A[i])) {
                int indexToCount = s.pop();
                int left = indexToCount - (s.isEmpty() ? -1 : s.peek());
                int right = i - indexToCount;
                res += (long)A[indexToCount] * left * right;
            }
            s.push(i);
        }
        return res;
    }
}

class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            long min = (int)nums[i], max = (int)nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                res += max - min;
            }
        }
        return res;
    }
}
