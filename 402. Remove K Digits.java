class Solution {
    public String removeKdigits(String num, int k) {
        //策略是尽量删除前面的，因为位数高，所以删除每个的峰值比如13292应该删除3下一个选项是9
        if (num.length() == k) return "0";//corner case
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < num.length()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {//说明之前的大删掉
                k--;
                stack.pop();
            }
            stack.push(num.charAt(i++));
        }
        while (k > 0) {//比如1234最大的在最后，删去4,或者都相等111
            k--;
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') sb.deleteCharAt(sb.length() - 1);//注意0开头
        return sb.reverse().toString();
    }
}
