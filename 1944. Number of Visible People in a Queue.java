class Solution { //It's quite similar idea with 496. Next Greater Element I problem.
    public int[] canSeePersonsCount(int[] heights) {
        if (heights == null || heights.length == 0) return new int[] {};
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) { //from right to left, because it sees people from left to right
            while (!stack.isEmpty() && heights[i] > stack.peek()) { //before store the current one, get rid of the shorter one on right which it can see
                stack.pop();
                res[i]++;
            }
            res[i] += stack.isEmpty() ? 0 : 1; //if it's not empty, that means there's a taller one and it could be seen
            stack.push(heights[i]);
        }
        return res;
    }
}
