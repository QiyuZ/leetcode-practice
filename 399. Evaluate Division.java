class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        // use table save string to integer
        Map<String, Integer> table = new HashMap<>();
        int len = 0;
        for (String[] strings : equations)
            for (String string : strings)
                if (!table.containsKey(string)) table.put(string, len++);

        // init map by direct equation
        double[][] map = new double[len][len];
        for (int i = 0; i < len; ++i)
            for (int j = 0; j < len; ++j)
                map[i][j] = (i == j ? 1.0 : Integer.MIN_VALUE);
        
        for (int i = 0; i < equations.length; ++i) {
            String[] keys = equations[i];
            int row = table.get(keys[0]);
            int col = table.get(keys[1]);
            map[row][col] = values[i];
            map[col][row] = 1 / values[i];
        }

        // floyd-warshall like algorithm
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                for (int k = 0; k < len; ++k) {
                    if (map[j][i] != Integer.MIN_VALUE && map[i][k] != Integer.MIN_VALUE) map[j][k] = map[j][i] * map[i][k];
                }
            }
        }
        
        for (int i = 0; i < len; ++i)
            for (int j = 0; j < len; ++j)
                if (map[i][j] == Integer.MIN_VALUE)
                    map[i][j] = -1.0;

        // query now
        double[] result = new double[query.length];
        for (int i = 0; i < query.length; ++i) {
            String[] keys = query[i];
            Integer row = table.get(keys[0]);
            Integer col = table.get(keys[1]);
            if (row == null || col == null) result[i] = -1.0;
            else result[i] = map[row][col];
        }
        return result;
    }
}
//思路用数字代表字母并且用二维数组当做结果
//ac = ab*bc
