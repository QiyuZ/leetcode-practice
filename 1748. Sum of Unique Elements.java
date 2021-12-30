class Solution {
    public int sumOfUnique(int[] nums) { //dont need 2 loops but just reduce the num if we found it appears before
        int[] records = new int[101];
        int res = 0;
        for (int num : nums) {
            if (records[num] == 0) res += num;
            else if (records[num] == 1) res -= num;
            records[num]++;
        }
        return res;
    }
}
