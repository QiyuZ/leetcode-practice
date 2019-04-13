class Solution {
    public int findRotateSteps(String ring, String key) {
        char[] rings = ring.toCharArray();
        char[] keys = key.toCharArray();
        return dfs(rings, keys, 0, 0, new HashMap<String, Integer>()) + keys.length;
    }
    
    private int dfs(char[] rings, char[] keys, int ringIdx, int keyIdx, HashMap<String, Integer> map) {
        if (keyIdx == keys.length) return 0;
        String key = ringIdx + "-" + keyIdx;
        if (map.containsKey(key)) return map.get(key);
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < rings.length; i++) {
            if (rings[i] != keys[keyIdx]) continue;
            int diff = Math.abs(i - ringIdx);
            int dis = Math.min(diff, rings.length - diff) + dfs(rings, keys, i, keyIdx + 1, map); //可正反时针
            minDis = Math.min(minDis, dis);
        }
        map.put(key, minDis);
        return minDis;
    }
}

//O(kr^2)
