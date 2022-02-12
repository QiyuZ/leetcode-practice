class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(w, left);
            right += w;
        }
        int avg = right % weights.length == 0 ? right / weights.length : (right / weights.length) + 1;
        left = Math.max(left, avg); //最小的装货量是单次最大的或者平均重量，最大可能的就是总和，比如就一天
        while (left < right) {
            int mid = left + (right - left) / 2;
            int days = daysToFinish(weights, D, mid);
            if (days > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }
    
    private int daysToFinish(int[] weights, int D, int mid) {
        int days = 0, cur = 0;
        for (int w : weights) {
            if (cur + w > mid) { //注意要提前判断因为不能有一次cur是超过限制的
                days++;
                cur = w;
            } else cur += w; 
        }
        return ++days; //最后一批货送出去
    }
}
