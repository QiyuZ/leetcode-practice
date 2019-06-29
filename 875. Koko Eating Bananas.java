class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 0, high = 0; //注意low从0开始因为H可以非常大
        for (int p : piles) high = Math.max(high, p);
        if (H <= piles.length) return high; //个数多，那么要求一次要全吃完一堆的，至少最大的那个
        while (low < high) {//binary
            int mid = low + (high - low) / 2, count = 0;
            for (int p : piles) {
                count += Math.ceil((double)p / mid);
            }
            if (count > H) low = mid + 1; //注意此处不考虑==H 因为double取的ceil所以真是数值比count小，即使==H 其实也不够H还没到最小值还可以减
            //else if (count == H) high--; 此处可以这样优化，也许
            else high = mid;
        }
        return low;
    }
}
