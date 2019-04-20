class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int start = 0, n = nums.length;
        while (start < n  && nums[start] == temp[start]) start++;
        int end = n - 1;
        while (end > start  && nums[end] == temp[end]) end--;
        return end - start + 1;
    }
}

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start =0, end = 0, max=nums[0],min=nums[nums.length-1];
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
            if(nums[i] < max) end = i; //找出不是升序的最后一个
            min = Math.min(min, nums[nums.length-1-i]);
            if(min < nums[nums.length-1-i]) start = nums.length-1-i; //找出不是降序的最后一个
        }
        return start == end ? 0 : end - start + 1;
    }
}

//[2, 6, 4, 8, 10, 9, 15]
//[2, 4, 6, 8, 9 ,10, 15]
