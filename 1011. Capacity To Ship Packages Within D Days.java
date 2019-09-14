class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(w, left);
            right += w;
        }
        left = Math.max(left, right / weights.length); //最小的装货量是单次最大的或者平均重量，最大可能的就是总和，比如就一天
        while (left < right) {
            int mid = left + (right - left) / 2;
            int day = 0, cur = 0;
            for (int w : weights) {
                if (cur + w > mid) { //注意要提前判断因为不能有一次cur是超过限制的
                    day++;
                    cur = w;
                } else cur += w; 
            }
            day += 1; //最后一批货送出去
            if (day > D) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}

