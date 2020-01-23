class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() < 2) return 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);//这里要看之前是什么来算长度比如()() ,每个）都可以弹出然后比较之前的那个
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                res = Math.max(res, i - stack.peek()); 
            } else stack.push(i);
        }
        return res;
    }
}
