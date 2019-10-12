class Solution {
    public String smallestSubsequence(String text) {
        Stack<Character> stack = new Stack<>();
        int[] last = new int[26];
        boolean[] seen = new boolean[26];
        for (int i = 0; i < text.length(); i++) last[text.charAt(i) - 'a'] = i;
        for (int i = 0; i < text.length(); i++) {
            char cur = text.charAt(i);
            if (seen[cur - 'a']) continue;//前面加过了，顺序前面的优先后面跳过
            while (!stack.isEmpty() && stack.peek() > cur && last[stack.peek() - 'a'] > i) { //新进来的char小，那么如果后面还有peek的话小的应该存在
                seen[stack.pop() - 'a'] = false;
            }
            stack.push(cur);
            seen[cur - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}

