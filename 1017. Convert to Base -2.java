class Solution {
    public String baseNeg2(int N) {
        if (N == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (N != 0) {
            int r = N % (-2);
            N = N / (-2);
            if (r == -1) {
                r = 1;
                N++; //注意是+1不是2因为前面已经/2了
            }
            sb.append(r);
        }
        return sb.reverse().toString();
    }
}
