class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length <= 2) return true;
        if (coordinates[0][0] == coordinates[1][0]) {
            for (int[] c :coordinates) {
                if (c[0] != coordinates[0][0]) return false;
            }
            return true;
        }
        double scope = (double)(coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        for (int i = 2; i < coordinates.length; i++) {
            double deltaY = (double)(coordinates[i][1] - coordinates[i - 1][1]);
            double deltaX = (double)(coordinates[i][0] - coordinates[i - 1][0]);
            if ((deltaY / deltaX) != scope) return false;
        }
        return true;
    }
}

class Solution {
   public boolean checkStraightLine(int[][] coordinates) {
       // 移项 (y - y1) / (x - x1) = (y1 - y0) / (x1 - x0)
        int x0 = coordinates[0][0], y0 = coordinates[0][1], x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}
