class Solution {
    public String decodeString(String s) {
        if (s == null || s.isEmpty()) return s;
        Stack<Integer> count = new Stack<>();
        Stack<String> res = new Stack<>();
        res.push("");
        int i = 0, num = 0;
        while (i < s.length()) {
            char cur = s.charAt(i);
            if (cur >= '0' && cur <= '9') num = num * 10 + (cur - '0');
            else if (cur == '[') {
                res.push(""); //用“”分隔并且加的时候就可以变成了string,如果不分隔多个括号时会把之前的都加上
                count.push(num);
                num = 0;
            } else if (Character.isLetter(cur)) res.push(res.pop() + cur);
            else if (cur == ']') {
                String peek = res.pop();
                StringBuilder sb = new StringBuilder();
                int repeat = count.pop();
                for (int j = 0; j < repeat; j++) sb.append(peek);
                res.push(res.pop() + sb.toString());
            }
            i++;
        }
        return res.peek();
    }
}

class Solution {
    private int index = 0;
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index))) result.append(s.charAt(index++));
            else {
                int k = 0; // build k until next character is a digit
                while (index < s.length() && Character.isDigit(s.charAt(index))) k = k * 10 + s.charAt(index++) - '0';
                index++; // ignore the opening bracket '['
                String decodedString = decodeString(s); //注意这里还可以用s因为有global index来mark位置
                index++; // ignore the closing bracket ']'
                while (k-- > 0) result.append(decodedString); // build k[decodedString] and append to the result
            }
        }
        return result.toString();
    }
}
