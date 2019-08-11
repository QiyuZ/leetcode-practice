class Solution {
    public String largestTimeFromDigits(int[] A) { //不太好分类考虑，直接枚举
        String ans = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || i == k || j == k) continue;
                    String h = "" + A[i] + A[j], m = "" + A[k] + A[6 - i - j - k];
                    if (h.compareTo("24") < 0 && m.compareTo("60") < 0 && ans.compareTo(h + ":" + m) < 0) ans = h + ":" + m;
                } 
            }
        }
        return ans;
    }
}
