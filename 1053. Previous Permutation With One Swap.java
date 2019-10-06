class Solution {
    public int[] prevPermOpt1(int[] A) {
        if (A.length == 1) return A;
        int n = A.length, i = n - 2;
        while (i >= 0 && A[i] <= A[i + 1]) i--; //找到第一个从后到前的第一个上升的数，只有这个可以换
        if (i == -1) return A;
        int j = n - 1; 
        while (A[j] >= A[i]) j--; //那么另一个要换的就在这个数的右边，第一个不相等最大的
        while (j >= 1 && A[j - 1] == A[j]) j--; //另外还要注意，不相等最大也可以有多个一样的，要选择位置靠前的这样减小变化
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        return A;
    }
}
