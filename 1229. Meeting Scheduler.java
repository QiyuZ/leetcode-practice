class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        if (slots1 == null || slots2 == null || duration < 0) return new ArrayList<>();
        Arrays.sort(slots1, (a, b) -> (a[0] - b[0]));
        Arrays.sort(slots2, (a, b) -> (a[0] - b[0]));
        int i = 0, j = 0, m = slots1.length, n = slots2.length;
        while (i < m && j < n) {
            int start = Math.max(slots1[i][0], slots2[j][0]); //find intersection
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (end - start >= duration) return Arrays.asList(start, start + duration);
            if (start == slots1[i][0]) j++; //move the smaller one forward
            else i++;
        }
        return new ArrayList<>();
    }
}
