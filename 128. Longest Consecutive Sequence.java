class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int res = 1;
        for (int num : nums) set.add(num);
        for (int num : nums) { //精髓在于移除的对后面的没有影响，因为已经把连续的都考虑进去了
            int pre = num  - 1, next = num + 1;
            if (set.remove(num)) {
                while (set.remove(pre)) pre--;
                while(set.remove(next)) next++;
            }
            pre++;
            next--;
            res = Math.max(res, next - pre + 1);//这里其实是多走了一步停下来时是没有的
        }
        return res;
    }
}
