class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Set<String> bankSet = new HashSet<>();
        for (String s : bank) bankSet.add(s);
        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(start);
        queue.offer(start);
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) { //要记录这个size，不能让后面后面加上去的一次处理完
                String cur = queue.poll();
                if (cur.equals(end)) return steps;
                char[] curChar = cur.toCharArray();
                //替换每一个可能的，并把符合要求的放到queue和visited里面
                for (int i = 0; i < curChar.length; i++) {
                    char oldChar = curChar[i];
                    for (char c : charSet) {
                        curChar[i] = c;
                        String next = new String(curChar);
                        if (bankSet.contains(next) && !visited.contains(next)) {
                            queue.offer(next);
                            visited.add(next);
                        }
                        curChar[i] = oldChar; //别忘记换回去
                    }
                }
            }
            steps++; //这一轮没有，就要+1
        }
        return -1;
    }
}
