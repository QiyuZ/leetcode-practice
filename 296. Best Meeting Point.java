class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        List<Integer> row = new ArrayList<>();
        List<Integer> col= new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        return getDiff(row) + getDiff(col);
    }
    public int getDiff(List<Integer> list) {
        if (list.size() == 0) return 0;
        int start = 0, end = list.size() - 1;
        int res = 0;
        Collections.sort(list);
        while (start < end) res += list.get(end--) - list.get(start++);
        return res;
    }
}
/*其实就是找中点，但无论中点在哪左右（上下）到中点的距离不变，
比如例子中(0,0), (0,4),无论点在哪，横向的距离始终为4，这是由于distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
所以把x,y距离分开算，x,y方向的距离互不影响
*/
