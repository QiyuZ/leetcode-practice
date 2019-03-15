class Solution {
    public boolean isPerfectSquare(int num) {
        return findPerfectSquare(num,0,num);
    }
    
    public boolean findPerfectSquare(int num,int low,int high){
        if(low > high) return false;
        if(low == high) return low == num / (double)low;
        int mid = low + (high - low) / 2;
        if(mid == num / (double)mid) return true;
        else if(mid < num / (double)mid) return findPerfectSquare(num,mid + 1,high);
        else return findPerfectSquare(num,low,mid - 1);
        
        
    }
}
