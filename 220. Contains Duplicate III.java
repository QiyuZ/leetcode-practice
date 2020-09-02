class Solution { //O(nlog(min(n,k)))
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) { //每次新加入的数找最大或者最小，如果超过K则remove最前面的
            Integer lower = set.floor(nums[i]), higher = set.ceiling(nums[i]);
            if ((lower != null && (long)nums[i] - lower <= t) || (higher != null && higher - (long)nums[i] <= t)) return true; //注意要用long防止边界越界
            set.add(nums[i]);
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;
    }
}

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {//O(n)
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();//划分成不同bucket每次找邻近的再比较大小，超过K则删除最前面的
        long diff = t == 0 ? (long)t + 1 : (long)t; //防止t = 0 除不了
        for (int i = 0; i < nums.length; i++) {
            long key = (long)nums[i] < 0 ? (long)nums[i] / diff - 1 : (long)nums[i] / diff;
            if (map.get(key) != null) return true;
            if (map.get(key - 1) != null && (long)nums[i] - map.get(key - 1) <= t) return true;
            if (map.get(key + 1) != null && map.get(key + 1) - (long)nums[i] <= t) return true;
            map.put(key, (long)nums[i]);//前面已经查过没有
            if (map.size() > k) map.remove((long)nums[i - k] < 0 ? (long)nums[i - k] / diff - 1 : (long)nums[i - k] / diff);
        }
        return false;
    }
}
