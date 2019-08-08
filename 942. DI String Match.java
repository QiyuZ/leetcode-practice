class Solution {
    public int[] diStringMatch(String S) {
        int n = S.length(), i = 0, min = 0, max = n;
        int[] res = new int[n + 1];
        for (char c : S.toCharArray()) {
            if (c == 'D') res[i] = max--;
            else res[i] = min++;;
            i++;
        }
        res[n] = max;
        return res;
    }
}
