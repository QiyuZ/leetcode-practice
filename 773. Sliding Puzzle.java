class Solution {
    public int slidingPuzzle(int[][] board) { //BFS
        if (board == null || board.length == 0) return 0;
        String target = "123450";
        Set<String> visited = new HashSet<>(); //由于限制了2*3的array所以用string方便
        Queue<String> queue = new LinkedList<>();
        String start = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start += board[i][j];
            }
        }
        if (start.equals(target)) return 0;
        int[][] dirs = new int[][] { { 1, 3 }, { 0, 2, 4 }, { 1, 5 }, { 0, 4 }, { 1, 3, 5 }, { 2, 4 } };
        //此处表示0所在index的情况下可以和哪个位置的swap
        visited.add(start);
        queue.offer(start);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) return level;
                int zero = cur.indexOf("0"); //定位0 index
                for (int dir : dirs[zero]) { //遍历可以换的依次处理
                    String next = swap(cur, zero, dir);
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    queue.offer(next);
                }
            }
            level++;
        }
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }
}

/*
4 1 2
5 0 3 */
