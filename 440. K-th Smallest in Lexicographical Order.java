class Solution {
    public int findKthNumber(int n, int k) { //denary tree
        int cur = 1;
        k--; //第一个就是1，已经置为1就-1
        while (k > 0) {
            long gaps = countGaps(n, cur, cur + 1);
            if (k == gaps) return cur + 1; //正好cover那就是下一个
            else if (k > gaps) { //说明不在这个范围内，所以往下走
                k -= gaps;
                cur++;
            } else { //在这个范围内，往里面找
                cur *= 10;
                k--;
            }
        }
        return cur;
    }
     private long countGaps(int n, long cur, long next) { //计算两个相邻的相差多少，比如1,2
         long gaps = 0;
         while (cur <= n) {
             gaps += Math.min(n + 1, next) - cur; //此时的next可能比范围要大，找小的，比如13， 20; +1是算上next本身
             cur *= 10;
             next *= 10;
         }
         return gaps;
     }
}
