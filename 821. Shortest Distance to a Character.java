class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) pos = i;
            res[i] = i - pos; //one pass, i一定大于pos
        }
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C) pos = i;
            res[i] = Math.min(Math.abs(pos - i), res[i]); //two pass时不一定，pass在前， i在后
        }
        return res;
    }
}
//two pass 正反来一遍找最小，related problem，找除了本身的其他元素之和
