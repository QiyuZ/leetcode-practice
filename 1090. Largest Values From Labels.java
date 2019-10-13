class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        int[][] pairs = new int[values.length][2];
        for (int i = 0; i < values.length; i++) pairs[i] = new int[] {values[i], labels[i]};
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });        
        Map<Integer, Integer> used = new HashMap<>();
        int res = 0;
        for (int[] p : pairs) {
            if (num_wanted == 0) break;
            if (used.containsKey(p[1]) && used.get(p[1]) == use_limit) continue;
            else {
                res += p[0];
                used.put(p[1], used.getOrDefault(p[1], 0) + 1);
                num_wanted--;
            }
        }
        return res;
    }
}
