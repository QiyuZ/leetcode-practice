class Solution {
    public int minDeletionSize(String[] A) {
        int res = 0;
        for (int i = 0; i < A[0].length(); i++) { //找有几个部分条件即可
            for (int j = 1; j < A.length; j++) {
                if (A[j - 1].charAt(i) > A[j].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
