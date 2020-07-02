class Solution {
    public int arrangeCoins(int n) {
        int count = 0;
        int i = 1;
        while(n > 0) {
            n -= i;
            if(n >= 0) count++;
            i++;
        }
        return count;
        
    }
}


class Solution {
    public int arrangeCoins(int n) {
        long l = 1, r = n;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long coins = (1 + mid) * mid / 2;
            if (coins == n) return (int)mid;
            else if (coins > n) r = mid;
            else l = mid + 1;
        }
        return (1 + l) * l / 2 > (long)(n) ? (int)(l - 1) : (int)(l);
    }
}

//找出恰好超出的那一行
