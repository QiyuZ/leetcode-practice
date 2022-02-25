class Solution {//for bfs, it's not get max in every level but on every branch
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) continue;
            if (!map.containsKey(manager[i])) map.put(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        return dfs(map, informTime, headID);
    }
    
    private int dfs(Map<Integer, List<Integer>> map, int[] informTime, int head) {
        if (!map.containsKey(head)) return 0;
        int res = 0;
        for (int next : map.get(head)) res = Math.max(res, dfs(map, informTime, next));
        return res + informTime[head]; //the current time cost is fixed as informTime[head], and for its children nodes' cost, we need to get the largest one
    }
}


class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (manager[i] == -1) continue;
            if (!map.containsKey(manager[i])) map.put(manager[i], new ArrayList<>());
            map.get(manager[i]).add(i);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {headID, 0}); //current person and time to inform him/her
        int res = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0], time = poll[1];
            res = Math.max(res, time); //actually just get the latest time the last patch of people get informed, till queue is empty
            if (!map.containsKey(cur)) continue;
            for (int next : map.get(cur)) queue.offer(new int[] {next, time + informTime[cur]}); //note it's informTime[cur]
        }
        return res;
    }
}

class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int res = 0;
        for (int i = 0; i < n; ++i) res = Math.max(res, dfs(i, manager, informTime));
        return res;
    }
    public int dfs(int i, int[] manager, int[] informTime) {
        if (manager[i] = -1) {
            informTime[i] += dfs(manager[i], manager, informTime);
            manager[i] = -1;
        }
        return informTime[i];
    }
}
