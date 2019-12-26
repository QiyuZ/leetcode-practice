class Solution {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return s;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) queue.offer(new int[] {i, count[i]});
        }
        StringBuilder sb = new StringBuilder();
        Queue<int[]> frozen = new LinkedList<>();
        //比如aaabbcc要设置一个缓冲区否则可能append a 放入queue后还是a在最前面，先让其放够k个再把之前的加上
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            sb.append((char)(cur[0] + 'a'));
            cur[1]--;
            frozen.offer(cur); //这一步不检查cur[1]因为这样即使是0也会加进去，这样frozen不会残余
            if (frozen.size() == k) {
                int[] pre = frozen.poll();
                if (pre[1] > 0) queue.offer(pre);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}

