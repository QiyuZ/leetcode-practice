class Solution {
    public void merge(int A[], int m, int B[], int n) {  
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 && j >= 0) A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        while (j >= 0) A[index--] = B[j--];
    }  
}
//A前面的不好动，那么就从后往前，哪个大，哪个就放到后（这里题目是说正好可以填充好）
//如果B还没完，那么就把剩下的节奏放入，A还没完就无所谓了，因为本来就在那儿
