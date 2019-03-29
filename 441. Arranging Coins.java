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


public int arrangeCoins(int n) {   
        //convert int to long to prevent integer overflow
        long nLong = (long)n;
        
        long st = 0;
        long ed = nLong;
        
        long mid = 0;
        
        while (st <= ed){
            mid = st + (ed - st) / 2;
            
            if (mid * (mid + 1) <= 2 * nLong){
                st = mid + 1;
            }else{
                ed = mid - 1;
            }
        }
        
        return (int)(st - 1);
    }
}

//找出恰好超出的那一行
