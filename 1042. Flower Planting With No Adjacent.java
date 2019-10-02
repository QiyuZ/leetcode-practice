class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] res = new int[N];
        for (int[] p : paths) {
            if (!map.containsKey(p[0])) map.put(p[0], new HashSet<>());
            if (!map.containsKey(p[1])) map.put(p[1], new HashSet<>());
            map.get(p[0]).add(p[1]);
            map.get(p[1]).add(p[0]);
        }        
        for (int i = 1; i <= N; i++) {
            Set<Integer> set = new HashSet<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4}));
            if (!map.containsKey(i)) { //没有的话设为default 1即可
                res[i - 1] = 1;
                continue;
            }
            for (int next : map.get(i)) {
                if (set.contains(res[next - 1])) set.remove(res[next - 1]); //去除已经有的， 因为是从1到N所以不会有重复
            }
            res[i - 1] = set.iterator().next();
        }
        return res;
    }
}


