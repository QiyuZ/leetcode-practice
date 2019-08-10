class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int p : pushed) {
            stack.push(p); //对于每个总会被加进去，所以这里不用判断
            while (!stack.isEmpty() && popped[i] == stack.peek()) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
