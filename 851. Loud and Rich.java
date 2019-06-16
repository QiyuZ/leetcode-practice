class Solution {
    private int[] res;
    private Map<Integer, List<Integer>> map = new HashMap<>();
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        for (int[] r : richer) {
            if (!map.containsKey(r[1])) map.put(r[1], new ArrayList<>());//记录比我富的人，再dfs找出安静那个
            map.get(r[1]).add(r[0]);
        }
        res = new int[quiet.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < quiet.length; i++) {
            res[i] = dfs(i, quiet);
        }
        return res;
    }
    private int dfs(int i, int[] quiet) {
        if (res[i] != -1) return res[i];
        res[i] = i; //可以是本身
        if (map.containsKey(i)) {
            for (int n : map.get(i)) {
                int rich = dfs(n, quiet);
                if (quiet[rich] < quiet[res[i]]) res[i] = rich; //注意要用res[i]因为可能已经变化不是i了
            }
        }
        return res[i];
    }
}
