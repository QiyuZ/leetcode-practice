class Solution {
    public int scoreOfParentheses(String S) {
        int multi = 0, res = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') { 
                //因为是balanced所以多一个左括号就是乘以2，到了最里面遇到了（），计算出这个的值，前一个不是（就除以2，这样不会影响下一个
                if(multi == 0) multi = 1;
                else multi *= 2;
            }
            else {
                if (S.charAt(i - 1) == '(') res += multi;
                multi /= 2;
            }
        }
        return res;
    }
}

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0; //每次置0因为可能有新的一组
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }
