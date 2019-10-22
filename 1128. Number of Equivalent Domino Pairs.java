class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] d : dominoes) {
            String key = Math.max(d[0], d[1]) + "-" + Math.min(d[0], d[1]); //特征值
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int res = 0;
        for (int value : map.values()) res += value * (value - 1) / 2; //几个可以组成的组数
        return res;
    }
}
