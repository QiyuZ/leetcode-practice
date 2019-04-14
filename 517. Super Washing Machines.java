class Solution {
    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length == 0) return -1;
        int total = 0;
        for (int load : machines) total += load;
        int avg = total / machines.length;
        if (avg * machines.length != total) return -1;
        int res = 0, count = 0;
        for (int load : machines) {
            count += load - avg;
            res = Math.max(load - avg, Math.max(Math.abs(count), res));
        }
        return res;
    }
}

/* 变成需要多少
[0,0,11,5] -> [-4,-4,7,1]
So we get: [0,-8,7,1]
then: [0,0,-1,1]
lastly: [0,0,0,0], done.
其中最大的是-8即为8steps */
