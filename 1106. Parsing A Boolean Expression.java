class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (c == ',') continue;
            if (c == ')') {
                List<Character> list = new ArrayList<>();
                while (!stack.isEmpty() && stack.peek() != '(') list.add(stack.pop());
                stack.pop();
                stack.push(helper(list, stack.pop()));
            } else stack.push(c);
        }
        return stack.pop() == 't' ? true : false;
    }
    
    private char helper(List<Character> list, char sign) {
        if (sign == '!') return list.get(0) == 't' ? 'f' : 't';
        else if (sign == '|') {
            for (char c : list) {
                if (c == 't') return 't';
            }
            return 'f';
        } else {
            for (char c : list) {
                if (c == 'f') return 'f';
            }
            return 't';
        }
    }
}
