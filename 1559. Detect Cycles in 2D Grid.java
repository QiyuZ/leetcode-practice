class Solution {
    public boolean containsCycle(char[][] grid) {
        if (grid == null || grid.length < 2) return false;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j]) continue;
                if (dfs(i, j, grid, visited, grid[i][j])) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] grid, boolean[][] visited, char target) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != target) return false;
        if (visited[i][j]) return true; 
        //this doesn't mean it will return to original point but will visit an element that visited before, so we can tell there's a cycle
        //e.g. [["a","a"],["a","a"]] from (0,0), noving down will help mark all elements as visited, then moveing right will detect the cycle
        visited[i][j] = true;
        grid[i][j] = '*'; //mark as a special character so it can avoid case like (0, 0)->(0, 1) and then (0, 1) to (0, 0)
        boolean res = dfs(i + 1, j, grid, visited, target) || dfs(i - 1, j, grid, visited, target) 
            || dfs(i, j + 1, grid, visited, target) || dfs(i, j - 1, grid, visited, target);
        grid[i][j] = target; //dont forget to change it back, becase the other visits need it to be target 
        return res;
    }
}
