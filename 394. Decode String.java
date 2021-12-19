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
    private int index = 0; //global pos mark
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') { //end when next char is ], because when recursion we just wanna deal the part
            if (Character.isLetter(s.charAt(index))) res.append(s.charAt(index++)); //normal case, just letter
            else {
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) num = num * 10 + (s.charAt(index++) - '0'); //could be several digits number
                if (s.charAt(index) == '[') index++;
                String innerRes = decodeString(s); //dont need substring here as index is a global pos mark
                if (s.charAt(index) == ']') index++;
                while (num-- > 0) res.append(innerRes);
            }
        }
        return res.toString();
    }
}
