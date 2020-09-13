class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) { 
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) { //把等待考虑的作为newInterval， 下面其实按照左右不变中合并三种情况
            if (newInterval[0] > interval[1]) res.add(interval);//左边无重合直接把左边的加进去
            else if (interval[0] > newInterval[1]) {
                //右边的无重合，直接把newInterval加进去相当于在中间，之所以是右边是因为上面一行可能把左边直接加进去
                res.add(newInterval);
                newInterval = interval;//把右边未验证的作为newInterval
            }
            else newInterval = new int[] {Math.min(newInterval[0], interval[0]), Math.max(newInterval[1], interval[1])};
            //有重合，此时找overlap,但是不能加进去，因为可能和后面有重合，所以继续走
        }
        res.add(newInterval);//把等待考虑的作为newInterval，最后会剩下一个
        return res.toArray(new int[0][0]);
    }
}
