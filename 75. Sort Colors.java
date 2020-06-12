class Solution {
    public void sortColors(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                //if current is 0, swap with p1 pointer, increment p1
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                //if current is 2, swap with p2 pointer, decrement p2
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                //may have swapped an extra 0 from the end of array that requires extra processing, so decrement index to account for it
                index--;
            }
            //move to next index to make progress
            index++;
        }
    }
}


class Solution { //2-pass
    public void sortColors(int[] nums) {
        int zero = 0, one = 0;
        for (int num : nums) {
            if (num == 0) zero++;
            else if (num == 1) one++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < zero) nums[i] = 0;
            else if (i >= zero && i < zero + one) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
