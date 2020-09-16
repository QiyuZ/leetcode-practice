class Solution {
    public int findMaximumXOR(int[] nums) {
        int res = 0, mask = 0;
        for (int i = 31; i >= 0; i--) { //一位一位的找
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num & mask);
            int greedy = res | (1 << i);
            for (int left : set) {
                if (set.contains(left ^ greedy)) res = greedy; 
                //a ^ b = c => a ^ b ^ a = c ^ a  (a ^ a = 1)then a ^ c = b
            }
        }
        return res;
    }
}

//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049/Java-O(n)-solution-using-bit-manipulation-and-HashMap
