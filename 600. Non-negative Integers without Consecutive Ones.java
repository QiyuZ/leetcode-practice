class Solution {
    public int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
        int n = sb.length();
        int[] a = new int[n], b = new int[n];
        a[0] = 1; //end with 0
        b[0] = 1; //end with 1
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }
        int res = a[n - 1] + b[n - 1];
        for(int i = 1; i < n; i++) {
            //已知结果中不含有11的，如果当前位是11那么就不用再往下走了 因为就不能有11，既然有了res里含有的答案一定比它小，肯定在范围内
            if(sb.charAt(i) == '1' && sb.charAt(i - 1) == '1') break;
            if(sb.charAt(i) == '0' && sb.charAt(i-1) == '0')  res = res - b[n - i - 1]; //删去01,10情况
        }
        return res;
    }
}
