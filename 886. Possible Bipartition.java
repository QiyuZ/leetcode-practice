class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) { //二分图，染色法
        if (dislikes.length == 0) return true;
        int[] color = new int[N + 1];//because start from 1
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());
        for (int[] dis : dislikes) {
            list.get(dis[0]).add(dis[1]); //前后都要相互连接
            list.get(dis[1]).add(dis[0]);
        }
        for (int i = 1; i <= N; i++) {
            if (color[i] != 0) continue;
            color[i] = 1; //默认为组1，因为如果是0说明和前面都没有任何联系
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int nb : list.get(cur)) {
                    if(color[nb] == 0) {
                        color[nb] = color[cur] == 1 ? 2 : 1;
                        q.add(nb);
                    } else if(color[nb] == color[cur]) return false;
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
