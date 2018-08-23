class Solution {  
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> right = new HashSet<>();
        Set<Integer> wrong = new HashSet<>();
        for(int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) wrong.add(fronts[i]);
            else {
                right.add(fronts[i]);
                right.add(backs[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int res : right) {
            if (!wrong.contains(res) && res < min) min = res;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
//如果正反面相同则一定不行，因为是所有的牌，问题转化为找剩下牌中最小的数字（注意要剔除上一步相等的数字）
// space: O(1)
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        int len = fronts.length;
        boolean[] buckets = new boolean[2001];
        for (int i = 0; i < fronts.length; ++i)
            if (fronts[i] == backs[i])
                buckets[fronts[i]] = true;
        int ans = 2000;
        for(int i = 0; i < len; ++i) {
            if (!buckets[fronts[i]])
                ans = Math.min(ans, fronts[i]);
            if (!buckets[backs[i]])
                ans = Math.min(ans, backs[i]);
        }
        return ans % 2000;
    }
}
