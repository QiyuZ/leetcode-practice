class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Set<Integer> visited = new HashSet<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) { 
            //由于可能多条线路包含相同的站点，而且我们要求过了几个线路而不是过了几站，所以此处放入这个站点对应的全部线路，
            for (int j = 0; j < routes[i].length; j++) { //注意这里用routes[i],因为每个数组长短不一
                ArrayList<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<Integer>());//检查是否存在对应，并在后添加
                buses.add(i);
                map.put(routes[i][j], buses);
            }
        }       
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); //注意分层时，要+1 res
            res++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                ArrayList<Integer> buses = map.get(cur);
                if (buses == null || buses.size() == 0) continue;
                for (int bus : buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus); //删掉遍历过的线路防止重复遍历
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return res;
                        queue.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
