class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel) return 0;
        if (stations == null || stations.length == 0) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));
        int dist = startFuel, i = 0, res = 0;
        while (true) { //注意此处不可以queue.isEmpty()因为可能还没加完
            while (i < stations.length && dist >= stations[i][0]) queue.offer(stations[i++][1]);  
            //放入可以到的，但是吧可以跑远的放在前面，上一次的不用清空，因为可以一段区间内多次加，只要总数达
            if (dist >= target) return res; //可以到
            if (queue.isEmpty()) return -1; 
            res++;
            dist += queue.poll();
        }
    }
}

    public int minRefuelStops(int target, int cur, int[][] s) {
        Queue<Integer> pq = new PriorityQueue<>();
        int i = 0, res;
        for (res = 0; cur < target; res++) {
            while (i < s.length && s[i][0] <= cur)
                pq.offer(-s[i++][1]);
            if (pq.isEmpty()) return -1;
            cur += -pq.poll();
        }
        return res;
    }
