class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return res;
        for (int[] interval : intervals) {
            if (toBeRemoved[0] >= interval[1] || interval[0] >= toBeRemoved[1]) res.add(Arrays.asList(interval[0], interval[1])); //no overlap, use >= as it mentions that [a, b)
            else { //use else means the following cases won't be "no overlap" ^^
                if (toBeRemoved[0] > interval[0]) res.add(Arrays.asList(interval[0], toBeRemoved[0])); //left overlap, add non-overlap part
                if (interval[1] > toBeRemoved[1]) res.add(Arrays.asList(toBeRemoved[1], interval[1])); //right overlap, add non-overlap part
                //note 1. here needs 2 if case as they could both happen 2. we ignore a case here that toBeRemoved has wider ranger than interval, because it will remove all interval. Just ignore
            }
        }
        return res;
    }
}
