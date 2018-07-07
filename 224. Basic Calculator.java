class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length(), sign = 1, res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {  //防止多位数，如123
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                res = res + num * sign;  //所有都看成加法，sign控制符号
            } else if (s.charAt(i) == '+') sign = 1;
            else if (s.charAt(i) == '-') sign = -1;
            else if (s.charAt(i) == '(') { //遇到括号，把之前的res好sign放进去，并初始化
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') res = res * stack.pop() + stack.pop(); 
        }
        return res;
    }
}
