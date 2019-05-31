class Solution {
    public boolean xorGame(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) xor ^= nums[i];
        return xor == 0 || nums.length % 2 == 0; 
        //结果为0 说明至少有两个不同是数字，那么Alice先手，只要保持这个就行（BOB不会主动使其变成0），最后相当于就剩下两个，Alice随便擦去一个，剩下一个只能给bob;
        //或者一直无法分胜负，直到用完，因为Alice先手，所以如果偶数个，最后那个就是Bob抹去的
    }
}
