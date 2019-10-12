class Solution {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num == 0) count++;
        }
        int len = count + arr.length;
        for (int i = arr.length - 1, j = len - 1; i >= 0 && j >= 0; i--, j--) { //i是原数组的指针，j是新数组的
            if (arr[i] != 0) {
                if (j < arr.length) arr[j] = arr[i]; //不是0，而且j的范围在老的之内，copy
            } else {
                if (j < arr.length) arr[j] = arr[i]; //能不能copy老的0
                j--; //0的数量-1
                if (j < arr.length) arr[j] = arr[i]; //能不能加上新的0
            }
        }
    }
}
