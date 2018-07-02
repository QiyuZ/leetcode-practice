class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] mark = new boolean[n]; //index = number
        int count = 0;
        for (int i = 2; i < n; i++) {//note, start from 2 
            if (mark[i] == false) {
                count++;
                for (int j = 2; j * i < n; j++) mark[i * j] = true;
            }
        }
        return count;
    }
}
/*找到一个prime number 就可以把与之相关的非prime number标记出来*/
