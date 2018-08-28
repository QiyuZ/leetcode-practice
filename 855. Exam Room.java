class ExamRoom {
    int N;
    PriorityQueue<int[]> queue;
    public ExamRoom(int N) {
        this.N = N;
        queue = new PriorityQueue<>(new Comparator<int[]>(){ //数组的形式放入优先队列，距离（半径）作为标准
            public int compare(int[] o1, int[] o2) {
                int disA = getDis(o1);
                int disB = getDis(o2);
                return disA == disB ? o1[0] - o2[0] : disB - disA; //距离优先，若相等则坐标优先
            } 
        });
        queue.offer(new int[] {-1, N});
    }
    
    public int seat() {
        int[] cur = queue.poll();
        int res = 0;
        if (cur[0] == -1) res = 0; //左边没东西，直接放置(既然poll出了这个，说明距离最大，而右边有数字了，所以左边放，同理下边右边放)
        else if (cur[1] == N) res = N - 1; //右边没东西，直接放置
        else res = cur[0] + (cur[1] - cur[0]) / 2;
        queue.offer(new int[] {cur[0], res});
        queue.offer(new int[] {res, cur[1]});
        return res;
    }
    
    public void leave(int p) {
        int[] left = null, right = null;
        for (int[] cur : queue) { //找到这个数字（分别作为开始和结尾的）
            if (cur[1] == p) left = cur;
            if (cur[0] == p) right = cur;
        }
        queue.remove(left); //删除旧区间，加入新的
        queue.remove(right);
        queue.offer(new int[] {left[0], right[1]});
    }
    
    public int getDis(int[] o) {
        int dis = 0;
        if (o[0] == -1) dis = o[1]; //说明左边没东西，不用除以2
        else if (o[1] == N) dis = N - 1 - o[0]; //说明右边没东西，不用除以2
        //注意这里不可以直接写等于N或者0，因为可能是后期被挪走，不一定是N或者0
        else dis = (o[1] - o[0]) / 2;
        return dis;
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
