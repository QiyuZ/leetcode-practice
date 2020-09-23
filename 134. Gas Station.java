class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0; i < diff.length; i++) diff[i] = gas[i] - cost[i];
        int sum = 0, total = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += diff[i];
            if (sum < 0) { //如果这个小于0说明前一个index不是起点,重新置为0，从下一个开始
                sum = 0; 
                index = i + 1;
            }
            total += diff[i];
        }
        return total < 0 ? -1 : index;
    }
}
