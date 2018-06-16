class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i <= heights.length; i++) { //后面多一位是默认一个0，因为是找不是升序的一个，可能一直升序，则不能pop，这样避免了这种情况
            int h = (i == heights.length ? 0 : heights[i]);
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int area = height * (i - start - 1); //比如现在在2，第一次计算6的面积，i=4, start=2,所以还要减1
                res = Math.max(res, area);
            }
            stack.push(i);
        }
        return res;
    }
}

//整体思路为，升序的入栈，找到第一个不是升序的，往左边依次出栈，计算可能的最大面积
