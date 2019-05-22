class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int num : map.keySet()) {
            int group = map.get(num) / (num + 1);
            res += map.get(num) % (num + 1) == 0 ? group * (num + 1) : (group + 1) * (num + 1);
        }
        return res;
    }
}

/*
比如 说8 的有1个则有9 个，说8 的有7个8有9个，说8 的有9 个一共9个，但是说8 的有10个，那个前9个是一组，后面一个单独，即18个
可见n+1形成一组，多出来的不够一组也要补上一组 */
