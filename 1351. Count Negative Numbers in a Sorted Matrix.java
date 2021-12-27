class Solution { //O(m * logn)
    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int[] g : grid) {
            int l = 0, r = g.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (g[mid] >= 0) l = mid + 1; //be careful even it's 0, it should move to right part
                else r = mid;
            }
            res += g[l] >= 0 ? g.length - l - 1 : g.length - l; //it's possibe all of them are pos, so check the stopped value
        }
        return res;
    }
}

class Solution { //O(m + n)
    public int countNegatives(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int r = grid.length - 1, c = 0, res = 0;
        while (r >= 0 && c < grid[0].length) {
            if (grid[r][c] < 0) {
                r--;
                res += grid[0].length - c;
            } else c++;
        }
        return res;
    }
}
