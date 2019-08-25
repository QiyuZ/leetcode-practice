class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] travel = new boolean[366];
        for (int day : days) travel[day] = true;
        int[] money = new int[366];
        money[0] = 0;
        for (int i = 1; i <= 365; i++) {
            if (!travel[i]) {
                money[i] = money[i - 1];
                continue;
            }
            int min1 = money[i - 1] + costs[0]; //注意当是一天的时候，要用前一天的加，因为当前的是0
            int min2 = money[Math.max(0, i - 7)] + costs[1];
            int min3 = money[Math.max(0, i - 30)] + costs[2];
            money[i] = Math.min(min1, Math.min(min2, min3));
        }
        return money[365];
    }
}

