class Solution {
    public boolean carPooling(int[][] trips, int capacity) { //we dont need to check one by one like from 1 to 1000, but just from and end
        if (capacity == 0) return true;
        List<int[]> records = new ArrayList<>();
        for (int[] trip : trips) {
            records.add(new int[] {trip[1], trip[0]}); //add people at from
            records.add(new int[] {trip[2], -1 * trip[0]}); //drop people at end
        }
        Collections.sort(records, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); //note here, we sort by position, but if they are the same, that means it needs to drop off people after pick up
        int count = 0;
        for (int[] r : records) {
            count += r[1];
            if (count > capacity) return false;
        }
        return true;
    }
}
