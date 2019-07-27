class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (c == ')' && (!stack.isEmpty() && stack.peek() == '(')) stack.pop();
            else stack.push(')');
        }
        return stack.size();
    }
}

    public int minAddToMakeValid(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length; ++i) {
            if (S.charAt(i) == '(') right++;
            else if (S.charAt(i) == ')' && right > 0) right--;
            else left++; //right <= 0 说明）过多此时需要（
        }
        return left + right;
    }
