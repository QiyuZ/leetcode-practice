class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(K, (a, b) -> ((a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1])));
        for (int[] p : points) queue.offer(p);
        int[][] res = new int[K][2];
        int i = 0;
        while (i < K) {
            res[i++] = queue.poll();
        }
        return res;
    }
}

public int[][] kClosest(int[][] points, int K) {
    Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
    return Arrays.copyOfRange(points, 0, K);
}

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || K < 1 || K > points.length) return new int[][] {};
        int l = 0, r = points.length - 1;
        while (l <= r) {
            int i = l;
            for (int j = l + 1; j <= r; j++) {
                if (compare(points[j], points[l]) < 0) swap(points, j, ++i);
            }
            swap(points, l, i);
            if (K < i) r = i - 1;
            else if (K > i) l = i + 1;
            else break;
        }
        return Arrays.copyOfRange(points, 0, K);
    }
    
    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }

    private void swap(int[][] nums, int i, int j) {
        int[] temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
