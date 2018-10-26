//triple disappear

public class ThreeCharDeduct {
    static String reduce(String s) {
        Stack<Character> stack = new Stack<>();
        char[] a = s.toCharArray();
        for (char c : a) {
            if (stack.size() < 2) {
                stack.push(c);
            } else {
                char first = stack.pop();
                char second = stack.pop();
                if (c == first && c ==second) {
                    continue;
                } else {
                    stack.push(second);
                    stack.push(first);
                    stack.push(c);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
