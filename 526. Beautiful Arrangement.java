class Solution { //O(k) valid permutation amount
    private int count = 0;
    public int countArrangement(int n) { //instead of find all permutations, we can focus on pos and stop earlier
        if (n < 2) return n < 0 ? 0 : n;
        boolean[] visited = new boolean[n + 1];
        backtracking(visited, n, 1);
        return count;
    }
    private void backtracking(boolean[] visited, int n, int pos) {
        if (pos > n) {
            count++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                backtracking(visited, n, pos + 1);
                visited[i] = false;
            }
        }
    }
}
