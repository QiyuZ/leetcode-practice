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



class Solution {
    
    Map<Integer, Integer> f = new HashMap<>();
    int islands = 0;

    public int removeStones(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], stones[i][1] + 10000);
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }
}
