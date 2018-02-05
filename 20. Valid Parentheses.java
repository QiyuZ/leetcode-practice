class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(') stack.push(')'); //先预先放上下一个可能的，如果不是就直接错
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
