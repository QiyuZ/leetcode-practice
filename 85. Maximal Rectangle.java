/*
结合leetcode 84   heights转化为一排的，每个元素是上面的和，有间断的1就重新置1， 一行一行过更新最大值，也是DP
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            countHeight(matrix, heights, i);
            res = Math.max(res, max2D(heights));
        }
        return res;
    }
    
    public void countHeight(char[][] matrix, int[] heights, int index) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[index][i] == '1') heights[i]++;
            else heights[i] = 0; //注意间断的不算面积，所以同理要重新计数
        }
    }
    
    public int max2D(int[] heights) {  //完全和84一样
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            while (!s.isEmpty() && h < heights[s.peek()]) {
                int height = heights[s.pop()];
                int start = s.isEmpty() ? -1 : s.peek();
                int area = height * (i - start - 1); 
                max = Math.max(max, area);
            }
            s.push(i);
        }
        return max;
    }
}
