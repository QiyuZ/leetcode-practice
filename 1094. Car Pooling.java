class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips == null || trips.length == 0) return true;
        int[] map = new int[1001];
        for (int[] t : trips) {
            map[t[1]] += t[0];
            map[t[2]] -= t[0];
        }
        for (int num : map) {
            capacity -= num;
            if (capacity < 0) return false;
        }
        return true;
    }
}
