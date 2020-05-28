class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) { //same as 785 O(e + v) 节点数+边数
        if (dislikes == null || dislikes.length == 0) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] d : dislikes) { //form graph
            if (!map.containsKey(d[0])) map.put(d[0], new ArrayList<>());
            if (!map.containsKey(d[1])) map.put(d[1], new ArrayList<>());
            map.get(d[0]).add(d[1]);
            map.get(d[1]).add(d[0]);
        }
        int[] color = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (color[i] != 0) continue; //已经染色
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            color[i] = 1; //分为1，-1，默认为1
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                if (!map.containsKey(cur)) continue;
                for (int next : map.get(cur)) {
                    if (color[next] == -color[cur]) continue;//已经分过了，skip
                    else if (color[next] == color[cur]) return false; //dislike不能一个颜色
                    else if (color[next] == 0) {  //还未染色则染色相反并加入queue
                        color[next] = -color[cur];
                        queue.offer(next);
                    }
                }
            }
        }
        return true;
    }
}

// class Solution {
//     public boolean possibleBipartition(int N, int[][] dislikes) {
//         if (dislikes.length == 0) return true;       
//         Set<Integer> g1 = new HashSet<>();
//         Set<Integer> g2 = new HashSet<>();
//         g1.add(dislikes[0][0]);
//         g2.add(dislikes[0][1]);		
//         for (int i = 1; i < dislikes.length; i++) { 
//             if ((g1.contains(dislikes[i][0]) && g1.contains(dislikes[i][1]))
//                 || (g2.contains(dislikes[i][0]) && g2.contains(dislikes[i][1]))) {
//                 return false;
//             }
            
//             if (g1.contains(dislikes[i][0])) {
//                 g2.add(dislikes[i][1]);
//             } else if (g2.contains(dislikes[i][0])) {
//                 g1.add(dislikes[i][1]);
//             }

//             if (g1.contains(dislikes[i][1])) {
//                 g2.add(dislikes[i][0]);
//             } else if (g2.contains(dislikes[i][1])) {
//                 g1.add(dislikes[i][0]);
//             }
//         }
        
//         return true;
//     }
// }
