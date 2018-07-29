class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> map = new ArrayList<>();
        for (int i = 1; i <= n; i++) map.add(i);
        int[] factor = new int[n];
        factor[0] = 1;
        for (int i = 1; i < n; i++) factor[i] = i * factor[i - 1];
        k -= 1; //排序是是从1到k，但是代码里是从0到k所以要-1
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / factor[i - 1]; //最高位的index
            k %= factor[i - 1];  //相当于 k -= index * factor[i - 1]
            //比如n=4,k=18(-1=17)的全排列个数是之前的6 再*4，所以前一位确定后=3，那么剩下的就是3个数的排列,就相当于找n=3的第17%6=5位
            sb.append(map.get(index));
            map.remove(index); //不能有重复的所以要去掉
        }
        return sb.toString();
    }
}
