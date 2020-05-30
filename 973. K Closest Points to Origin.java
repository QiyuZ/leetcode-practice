
class Solution {
    public int[][] kClosest(int[][] points, int K) {  //O(nlogn)
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, K);
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int K) { //O(nlogk)
        if (points == null || points.length == 0 || K < 1) return new int[][] {};
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a, b) -> (b[1] - a[1]));
        for (int i = 0; i < points.length; i++) {
            queue.offer(new int[] {i, points[i][0] * points[i][0] + points[i][1] * points[i][1]});
            if (queue.size() > K) queue.poll();
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[queue.poll()[0]];
        }
        return res;
    }
}

class Solution { //O(n) worst case O(n^2)
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
