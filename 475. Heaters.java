class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int i = 0, res = 0;
        for (int house : houses) {
            while (i + 1 < heaters.length && Math.abs(house - heaters[i]) >= Math.abs(heaters[i + 1] - house)) i++;
            //找出每个房子最近的heater
            res = Math.max(res, Math.abs(house - heaters[i])); //计算所需最大的距离
        }
        return res;
    }
}
