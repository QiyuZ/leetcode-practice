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

/* tranverse the string
 * use two variables to record the minimim number of flip need to make the substring from (0 - i) to be MonoIncr with end with 1 or 0;
 * (1) for position i + 1, if preceding string is end with 1, the current string can only end with one, 
 *   so cntEndWithOne can only be used to update the next cntEndWithOne
 * (2) if the preceding string is end with zero, current string can either end with zero or one
 *   so cntEndWithZero can be used to update for both next cntEndWithOne and cntEndWithZero;
 */
class Solution {    
    public int minFlipsMonoIncr(String S) {
        if (S == null || S.length() <= 1) return 0;
        int n = S.length();
        int cntEndWithOne = 0, cntEndWithZero = 0;
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            cntEndWithOne = Math.min(cntEndWithZero, cntEndWithOne) + (c == '1' ? 0 : 1); //choose a min case and let this one to be one
            cntEndWithZero += c - '0'; //let current one to be zero
        }
        return Math.min(cntEndWithOne, cntEndWithZero);
    }
}
