class Solution {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.isEmpty()) return -1;
        int[] mark = new int[24 * 60]; //时间多少是固定的
        for (String time : timePoints) {
            String[] timeArray = time.split(":");
            int hour = Integer.parseInt(timeArray[0]);
            int min = Integer.parseInt(timeArray[1]);
            mark[hour * 60 + min]++;
        }
        int pre = -1, min = 24 * 60, first = mark.length, last = -1;
        for (int i = 0; i < mark.length; i++) {
            if (mark[i] >= 2) return 0;
            if (mark[i] > 0) {
                if (pre == -1) pre = i;
                else {
                    min = Math.min(min, i - pre);
                    pre = i;
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
            }
            
        }
        return Math.min(min, mark.length - last + first); //edge case, 首尾可能差更小
    }
}
