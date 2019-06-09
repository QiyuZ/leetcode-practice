class Solution {
    public int numSimilarGroups(String[] A) { //基本思路，每次计数，把同一组的都变null
        int res = 0;
        if (A == null) return 0;
        if (A.length < 2) return A.length;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null) continue;
            String str = A[i]; //不是null就说明是新的一组
            A[i] = null;
            dfs(A, str);
            res++;
        }
        return res;
    }
    
    private void dfs(String[] A, String str) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null) continue;
            if (check(A[i], str)) {
                String newStr = A[i]; 
                A[i] = null;
                dfs(A, newStr); //把这个变形也dfs
            }
        }
    }
    
    private boolean check(String a, String b) {
        int diff = 0, i = 0;
        if (a.length() != b.length()) return false;
        for (; i < a.length(); i++) {
            if (diff > 2) break; //save some time
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return (diff == 0 || diff == 2) && i == a.length(); //可以是完全相同的两个，或者是两个位置不同说明是换了一个位置
    }
}
