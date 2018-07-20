class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        int n = nums.length;
        Integer[] res = new Integer[n]; //这里要用Integer,不然后面不能Arrays.asList()
        for (int i = n - 1; i >= 0; i--) {
            int index = findIndex(list, nums[i]);
            res[i] = index;
            list.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }
    //从后面开始，因为后面右边是从0开始，找出每个元素sort的index就是结果
    public int findIndex(List<Integer> list, int target) {
        if (list.size() == 0) return 0;
        int start = 0, end = list.size() - 1;
        if (list.get(start) >= target) return 0; //因为有可能插到之前和之后，而一般的二分搜索是在之间，要检查特殊情况
        if (list.get(end) < target) return end + 1;
        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (list.get(mid) < target) start = mid + 1;
            else end = mid;
        }
        return start; //每回都是start+1所以结果是返回start，比如1,6插入2，mid=0，新的start=1
    }
}
