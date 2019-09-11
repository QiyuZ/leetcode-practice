class Solution {
    public int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();    
        if (N == 1) return 1;
        stack.push(N--);
        char[] operations = new char[] {'*', '/', '+', '-'};
        int i = 0;
        while (N > 0) {
            if (operations[i] == '*') stack.push(stack.pop() * N--);
            else if (operations[i] == '/') stack.push(stack.pop() / N--);
            else if (operations[i] == '+') stack.push(N--);
            else stack.push(-1 * N--);
            i = (i + 1) % 4; //注意此处要取余防止越界
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
