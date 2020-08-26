class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;
        int[] travel = new int[days[days.length - 1] + 1];//标记每一日的最小花费
        int index = 0;
        for (int i = 1; i < travel.length; i++) { 
            if (days[index] == i) { //如果是旅行日每次都有三种情况，今天的花费加上前面花费的总和，而之前总和要退后相应天数去找
                int day = travel[i - 1] + costs[0];
                int week = travel[Math.max(0, i - 7)] + costs[1];//注意可能小于0
                int month = travel[Math.max(0, i - 30)] + costs[2];
                travel[i] = Math.min(day, Math.min(week, month));
                index++;
            } else travel[i] = travel[i - 1]; //非旅行日不买
        }
        return travel[travel.length - 1];
    }
}
