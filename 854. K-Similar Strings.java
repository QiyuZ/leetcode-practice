class Solution {
    public int kSimilarity(String A, String B) {
        if (("".equals(A) && "".equals(B)) || A.equals(B)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(A);
        queue.offer(A);
        int step = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int count = 0; count < size; count++) {
                String cur = queue.poll();
                int i = 0;
                while (cur.charAt(i) == B.charAt(i)) i++; //找出第一个不相等的进行替换
                for (int j = i + 1; j < B.length(); j++) {
                    //j位置，如果不等于cur.i那么没必要换，如果cur.j 和 B.j相等，那么换了以后i位相等位j位又不相等，相当于没换，所以都跳过
                    if ((cur.charAt(i) != B.charAt(j)) || cur.charAt(j) == B.charAt(j)) continue; 
                    String swapped = swap(cur, i, j);
                    if (swapped.equals(B)) return step;
                    if (visited.contains(swapped)) continue;
                    visited.add(swapped); queue.offer(swapped);
                }
            }
        }
        return -1;
    }
    
    private String swap(String s, int i, int j) {
        char[] ca = s.toCharArray();
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
        return new String(ca);
    }
}

