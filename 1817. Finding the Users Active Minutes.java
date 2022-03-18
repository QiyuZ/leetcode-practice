class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log: logs) {
            int id = log[0], time = log[1];
            if (!map.containsKey(id)) map.put(id, new HashSet<>());
            Set<Integer> times = map.get(id);
            if (times.size() != 0) ans[times.size() - 1]--; //the val has been added, so the pre count changes
            times.add(time);
            ans[times.size() - 1]++; //new val added
        }

        return ans;
    }
}
