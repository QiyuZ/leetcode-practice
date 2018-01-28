class Solution {
    public String decodeString(String s) {
        if (s.length() == 0 || s == null) return "";
        Stack<Integer> count = new Stack<>();
        Stack<String> res = new Stack<>();
        //因为是char要转换为str,先放入“”，可能第一个就是字符比如 ab
        res.push("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //放入count，可能是多位数
            if (c >= '0' && c <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } 
            //因为是char要转换为str,先放入“”
            else if (c == '[') res.push("");
            else if (c == ']') {
                String str = res.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j++) sb.append(str);
                //放入时注意要和前面的连接到一起，因为可能会有嵌套的格式3[a2[c]]
                res.push(res.pop() + sb.toString());
            }
            else res.push(res.pop() + c);
        }
        //遍历完，这里面应该就只有一个
        return res.pop();
    }
}
