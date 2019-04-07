class Solution {
    double r, x, y;
        
    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }
    
    public double[] randPoint() {
        Random rand = new Random();
        Double nx = x - r + rand.nextDouble() * 2 * r; //到最左边，然后+2倍的r*随机数
        double ny = y - r + rand.nextDouble() * 2 * r;
        double r2 = r * r;
        if (dis(nx, ny) >= r2) return randPoint();
        return new double[]{nx, ny};
    }
    
    // it returns the square of the distance between the point and the center;
    double dis(double nx, double ny){
        return (nx - x) * (nx - x) + (ny - y) * (ny - y);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
