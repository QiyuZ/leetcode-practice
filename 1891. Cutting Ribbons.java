class Solution {
    public int maxLength(int[] ribbons, int k) {
        int low = 1, high = Integer.MIN_VALUE;
        long sum = 0; //need to be long, in case out of bound of integer
        for (int ribbon : ribbons) {
            high = Math.max(high, ribbon);
            sum += ribbon;
        }
        if (sum == k) return 1;
        if (sum < k) return 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int amount = validRibbons(ribbons, mid);
            if (amount >= k) low = mid + 1; //even the amount is k, we need to assume that it could increase until the limit, rather than return mid
            else high = mid;
        }
        return validRibbons(ribbons, low) < k ? low - 1 : low; //the stop one may not be valid, check one more time to -1 if needed
    }
    
    private int validRibbons(int[] ribbons, int length) {
        int res = 0;
        for (int ribbon : ribbons) res += ribbon / length;
        return res;
    }
}
