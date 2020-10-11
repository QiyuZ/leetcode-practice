class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() < 2) return s;
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        boolean[] used = new boolean[26];
        for (char ch : s.toCharArray()) count[ch - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']--; //无论有无本轮使用都要-1因为个数都减少了
            if (used[s.charAt(i) - 'a']) continue;
            while (!stack.isEmpty() && s.charAt(i) < stack.peek() && count[stack.peek() - 'a'] > 0) used[stack.pop() - 'a'] = false; //弹出并标记
            //如果peek大，并且后面还有，就把当前的换掉因为可以方面在放上
            stack.push(s.charAt(i));
            used[s.charAt(i) - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        return sb.toString();
    }
}
