class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int i = 0, j = 0, k = 0;
        for (int index = 1; index < n; index++) {
            int res0 = 2 * ugly[i];//ugly number都是在小的ugly number上乘以2,3,5，所以找到candidate并移动对应基数
            int res1 = 3 * ugly[j];
            int res2 = 5 * ugly[k];
            int res = Math.min(res0, Math.min(res1, res2));
            ugly[index] = res;
            if (res == res0) i++; //这里不能else if要用if，因为比如15即是3的也是5的，此时j,k都要增加避免加入重复的数
            if (res == res1) j++;
            if (res == res2) k++;
        }
        return ugly[n - 1];
    }
}
