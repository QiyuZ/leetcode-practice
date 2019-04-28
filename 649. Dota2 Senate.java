class Solution {
    public String predictPartyVictory(String senate) {
        if (senate == null || senate.length() == 0) return "";
        int len = senate.length();
        Queue<Integer> queueR = new LinkedList<>(), queueD = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            char cur = senate.charAt(i);
            if (cur == 'R') queueR.offer(i);
            else if (cur == 'D') queueD.offer(i);
        }
        while (!queueR.isEmpty() && !queueD.isEmpty()) {
            int r = queueR.poll(), d = queueD.poll();
            if (r < d) queueR.offer(r + len); //小的先发制人还能活到下一轮
            else queueD.offer(d + len);
        }
        return queueR.size() > queueD.size() ? "Radiant" : "Dire";
    }
}

//greedy
