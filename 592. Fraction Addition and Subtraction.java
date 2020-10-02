class Solution {
    public String fractionAddition(String expression) {
        String[] fracs = expression.split("(?=[-+])");//带上delimiter,所以正负号会被都带上
        int[][] nums = new int[fracs.length][2];
        int index = 0;
        for (String frac : fracs) {
            String[] pair = frac.split("/");
            nums[index++] = new int[] {Integer.parseInt(pair[0]), Integer.parseInt(pair[1])};
        }
        int[] res = addFraction(nums);
        if (res[0] > 0 && res[1] < 0) {
            res[0] = -res[0];
            res[1] = Math.abs(res[1]);
        }
        return res[0] + "/" + res[1];
    }
    
    private int[] addFraction(int[][] nums) {
        if (nums == null || nums.length < 1) throw new IllegalArgumentException("Input nums needs at least two elements");
        int[] pre = nums[0];
        if (pre[1] == 0)  throw new IllegalArgumentException("Denominator cannot be zero");
        for (int i = 1; i < nums.length; i++) {
            int[] cur = nums[i];
            if (cur[1] == 0)  throw new IllegalArgumentException("Denominator cannot be zero");
            int gcfOfDen = getGcd(pre[1], cur[1]);
            int commonDen = pre[1] * cur[1] / gcfOfDen;
            int sumOfNum = pre[0] * commonDen / pre[1] + cur[0] * commonDen / cur[1];
            int gcdOfNum = getGcd(sumOfNum, commonDen);
            pre[0] = sumOfNum / gcdOfNum;
            pre[1] = commonDen / gcdOfNum;
        }
        return pre;
    }

    private int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
}
