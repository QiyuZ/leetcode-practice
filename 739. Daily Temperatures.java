class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); //保证时间是n，遇到大的就和栈里的peek比较，这样可以一次找出多个index的结果
        for (int i = 0; i < res.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int pos = stack.pop();
                res[pos] = i - pos;
            }
            stack.push(i);
        }
        return res;
    }
}
