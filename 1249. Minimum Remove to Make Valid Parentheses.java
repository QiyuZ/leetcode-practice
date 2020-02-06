class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s.isEmpty()) return s;
        int diff = 0; //the amount that left more than right paretheses
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') diff++;
            else if (c == ')') {
                if (diff == 0) continue; //已经平衡还有右括号那么就直接skip不加入，这样这一步就把多余的右括号去掉了
                else diff--;
            }
            sb.append(c);
        }
        StringBuilder res = new StringBuilder();
        if (diff == 0) return sb.toString(); //如果平衡则返回
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && diff > 0) { //该位是左括号并且左边仍然比右边多，则跳过，diff=0则说明剩下的是平衡的可以加
                diff--;
                continue;
            } else res.append(sb.charAt(i));
        }
        return res.reverse().toString();
    }
}
