class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) return 0;
        int start = timeSeries[0], end = timeSeries[0] + duration - 1, count = 0;
        for (int time : timeSeries) {
            if (time > end) {
                count += end - start + 1;
                start = time;
            }
            end = time + duration - 1;//end always needs to updated whether there are overlap or not
        }
        count += end - start + 1;
        return count;
    }
}


public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        if (timeSeries == null || timeSeries.length == 0) return 0;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i - 1] >= duration) count += duration; //没有重叠就算上整个duration
            else count += timeSeries[i] - timeSeries[i - 1]; //有重叠的话重叠部分会被包含在下一个里面，直接加差
        }
        return count + duration;
    }
}
