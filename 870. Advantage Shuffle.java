class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (b[0] - a[0])); //从大的开始，因为最大的如果没有对应的对于A就要去最小的，这样避免前面也没有对应的
        int[] res = new int[A.length];
        for (int i = 0; i < B.length; i++) queue.offer(new int[] {B[i], i}); //要记录坐标，即为res的坐标
        Arrays.sort(A);
        int low = 0, high = A.length - 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int val = cur[0], index = cur[1];
            if (A[high] > val) res[index] = A[high--]; //因为最大的先出来，那么A也从最大的开始
            else res[index] = A[low++];  //没有的话就找最小的
        }
        return res;
    }
}
