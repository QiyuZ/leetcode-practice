class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] count = new int[7];
        for (int a : A) count[a]++;
        for (int b : B) count[b]++;
        int max = 0, time = 0;
        for (int i = 0; i < 7; i++) {
            if (count[i] > time) {
                time = count[i];
                max = i;
            }
        }
        int swapA = 0, swapB = 0;
        if (time < A.length) return -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == B[i]) {
                if (A[i] == max) continue;//两者都等于
                else return -1; //都不等于这个位置就换不了
            } else if (A[i] == max)  swapB++; //如果换到B
            else if (B[i] == max)  swapA++; //如果换到A
            else return -1;
        }
        return Math.min(swapA, swapB);
    }
}
/*
其实只需要考虑出现次数最多的数字
case1： 出现最多的小于A长度，那么-1因为其他的也都不可以满足
case2:  等于长度，只能是它，看如何交换最小
case3： 大于长度也之只能是它，因为此种情况下出现次数第二大的肯定小于A.length, 处理方式同case2如何交换
*/
