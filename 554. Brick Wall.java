class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int res = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) { //关键一步不能包括最后一个数字，因为如果sum相等就是0，两边不可以穿过
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                res = Math.min(res, wall.size() - map.get(sum));
            }
        }
        return res;
    }
}

