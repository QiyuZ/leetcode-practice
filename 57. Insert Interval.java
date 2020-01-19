class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (newInterval == null || newInterval.length == 0) return intervals;
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) { //把等待考虑的当做newInterval
            if (newInterval[0] > interval[1]) res.add(interval);//interval在前面就放interval进去 newinterval不变
            else if (interval[0] > newInterval[1]) { //interval在后面就把后面的作为新的newInterval
                res.add(newInterval);
                newInterval = interval;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]); //有交集就合并这个作为newInterval,因为下面肯定会有先后顺序
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        res.add(newInterval); //最后会剩下一个没有merge的
        return res.toArray(new int[0][0]);
    }
