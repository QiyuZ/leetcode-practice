class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int cities = flights.length, weeks = days[0].length;
        int[][] memo = new int[cities][weeks];
        for (int[] m : memo) Arrays.fill(m, -1);
        return dfs(flights, days, 0, 0, memo);
    }
    private int dfs(int[][] flights, int[][] days, int city, int week, int[][] memo) {
        if (week == days[0].length) return 0; //reach the end
        if (memo[city][week] != -1) return memo[city][week];
        int max = 0;
        for (int i = 0; i < flights.length; i++) {
            if (flights[city][i] == 1 || i == city) {//either could fly or can stay at
                int cur = days[i][week] + dfs(flights, days, i, week + 1, memo); //current stay plus next week from city i
                max = Math.max(max, cur);
            }
        }
        memo[city][week] = max;
        return max;
    }
}
