class Solution {
    public int removeStones(int[][] stones) { //其实就是同横竖坐标的numbers of islands 
        Set<int[]> set = new HashSet<>();
        int res = 0;
        for (int[] s : stones) {
            if (!set.contains(s)) {
                res += dfs(stones, s, set, 0) - 1; //三个连接则可以取两个身下一个，所以是-1
            }
        }
        return res;
    }
    
    private int dfs(int[][] stones, int[] s, Set<int[]> set, int count) {
        set.add(s);
        count++;
        for (int[] cur : stones) {
            if (set.contains(cur)) continue;
            if (s[0] == cur[0] || s[1] == cur[1]) count = dfs(stones, cur, set, count);
        }
        return count;
    }
}


class Solution { //O(n)
    public int removeStones(int[][] stones) {
        Map<String, List<String>> graph = new HashMap<>();
        for (int[] stone : stones) {
            final String key0 = stone[0] + "", key1 = stone[1] + "!"; //since could be the same, use different string to identify
            if (!graph.containsKey(key0)) graph.put(key0, new ArrayList<>());
            if (!graph.containsKey(key1)) graph.put(key1, new ArrayList<>());
            graph.get(key0).add(key1);
            graph.get(key1).add(key0);
        }
        int numOfComponent = 0;
        Set<String> visited = new HashSet<>();
        for (int[] stone : stones) {
            for (int i = 0; i < 2; i++) {
                String key = i == 0 ? stone[0] + "" :stone[1] + "!";
                if (!visited.contains(key)) {
                    numOfComponent++;
                    dfs(key, graph, visited);
                }
            } 
        }
        return stones.length - numOfComponent; //eg. if there's just 1 component (all connected), then we only keep 1 of the element and remove others, so the removed is the substract result
    }
    
    private void dfs(String stone, Map<String, List<String>> graph, Set<String> visited) {
        if (visited.add(stone)) {
            for (String next : graph.get(stone)) dfs(next, graph, visited);
        }
    }
}
