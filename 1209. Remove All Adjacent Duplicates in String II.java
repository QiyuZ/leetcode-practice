class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().value == cur) {
                if (stack.peek().freq == k - 1) stack.pop();
                else stack.peek().freq += 1;
            } else stack.push(new Pair(1, cur));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair cur = stack.pop();
            for (int i = 0; i < cur.freq; i++) sb.append(cur.value);
        }
        return sb.reverse().toString();
    }
    
    class Pair {
        int freq;
        char value;
        public Pair (int freq, char value) {
            this.freq = freq;
            this.value = value;
        }
    }
}
