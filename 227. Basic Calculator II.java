class Solution {
    public int calculate(String s) { //因为没有括号可以直接计算
        Stack<Integer> nums = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num = num * 10 + (s.charAt(i) - '0');
                }
                if (sign == '-') nums.push(-num); //记录符号，如果是加减可以直接放入正负数字
                else if (sign == '+') nums.push(num);
                else if (sign == '*') nums.push(nums.pop() * num); //乘除则进行运算
                else if (sign == '/') nums.push(nums.pop() / num);
            } 
            else sign = c;
        }
        int res = 0;
        while (!nums.isEmpty()) res += nums.pop(); //剩下的都是计算好的，加的形式
        return res;
    }
}


class Solution {
    public int calculate(String s) {
        s = s.replace(" ","");
        int len = s.length();
        int result = 0, pre = 0, i = 0; char sign='+';
        while (i < len) {
            int current = 0;
            while (i < len && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                current = current * 10 + s.charAt(i) - '0';
                i++;
            }
            if (sign == '+' || sign == '-') {
                result += pre;
                pre = (sign == '+' ? current : -current);
            } else if (sign == '*') pre *= current;
            else if (sign == '/') pre /= current;
            if (i < len) sign = s.charAt(i++);
        }
        return result + pre;
    }
}
