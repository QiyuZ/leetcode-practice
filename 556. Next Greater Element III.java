public class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = (n + "").toCharArray();
        int i = nums.length - 1, j = nums.length - 1; 
        while (i > 0 && nums[i] <= nums[i - 1]) i--; //找到第一个从又开始下降的，比如6349871找到4
        if (i == 0) return -1;  //如果到0说明没有，比如 321
        i--; //跳到那个字符
        while (nums[j] <= nums[i]) j--;//找到上升序列中第一个比它大的，进行交换
        char exchange = nums[i];
        nums[i] = nums[j];
        nums[j] = exchange;
        Arrays.sort(nums, i + 1, nums.length); //把后面从小到大排列
        long res = Long.parseLong(new String(nums)); //注意越界，先用long
        return (res <= Integer.MAX_VALUE) ? (int)res : -1;
    }
}
