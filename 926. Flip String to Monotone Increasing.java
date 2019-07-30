class Solution {
    public int minFlipsMonoIncr(String S) {
        int[] left = new int[S.length() + 1];
        int[] right = new int[S.length() + 1];
        for (int i = 1, j = S.length() - 1; i <= S.length() && j >= 0; i++, j--) {
            left[i] += left[i - 1] + (S.charAt(i - 1) == '0' ? 0 : 1);
            right[j] += right[j + 1] + (S.charAt(j) == '0' ? 1 : 0);
        }
        int res = 20001;
        for (int i = 0; i <= S.length(); i++) res = Math.min(res, left[i] + right[i]); //左右两边表示全部翻转
        return res;
    }
}

public int minFlipsMonoIncr(String S) {
  int f0 = 0, f1 = 0;
  for (int i = 0; i < S.length(); ++i) {
    f0 += S.charAt(i) - '0';
    f1 = Math.min(f0, f1 + 1 - (S.charAt(i) - '0'));
  }
  return f1;
}
