class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) sb.append("a");
                else sb.append(matrix[i][j] == matrix[i][0] ? "a" : "b"); 
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        int res = 0;
        for (int num : map.values()) res = Math.max(res, num);
        return res;
    }
}
