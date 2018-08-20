class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < s.length(); i++) { //分情况讨论
            int num = 0; //每次循环更新0备用
            char cur = s.charAt(i);
            if (cur == ' ') continue; //仔细看。。竟然还有空格
            if (Character.isDigit(cur)) { //先看是不是数字，是的话可能好几位，找到这一串数字
                num = cur - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                nums.push(num); //加入nums 栈
            } else if (cur == '(') ops.push(cur);
            else if (cur == ')') { //遇到）可以计算一波，因为这是里面优先的
                while (ops.peek() != '(' ) nums.push(calculate(ops.pop(), nums.pop(), nums.pop())); //遇到（停止
                ops.pop(); //别忘了把（pop出去
            } else if (cur == '+' || cur == '/' || cur == '*' || cur == '-') { //遇到基础符号看优先级
                while (!ops.isEmpty() && !nums.isEmpty() && priority(cur, ops.peek()))  //其实检查ops,nums检查一个就行了，对应的
                    //注意ops.peek()是将要用到的，所以看优先级是检查它的不是cur
                    nums.push(calculate(ops.pop(), nums.pop(), nums.pop()));
                ops.push(cur); //不管有没有计算都要放入新的
            }
        }
        while (!ops.isEmpty()  && !nums.isEmpty()) nums.push(calculate(ops.pop(), nums.pop(), nums.pop()));
        //走完一遍一般都有剩下的，比如6-4 / 2，就剩6-2
        return nums.pop();
        //nums只剩一个最后数字
    }
    
    public int calculate (char op, int a, int b) { //四个操作
        if (op == '+') return a + b;
        else if (op == '*') return a * b;
        else if (op == '-') return b - a;
        else return b / a;
    }
    
    public boolean priority (char cur, char op) {
        if (op == '(' || op == ')') return false; //括号不能计算
        if ((cur == '*' || cur == '/') && (op == '+' || op == '-')) return false; 
        return true;
    } 
}
