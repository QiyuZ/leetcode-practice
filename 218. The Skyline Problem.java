class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] build : buildings) {
            height.add(new int[]{build[0], -build[2]}); //用负数mark,这样后面的排序负数（起点）会在前面
            height.add(new int[]{build[1], build[2]});
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));//优先考虑高的
        queue.offer(0); //数组里可能没有0，但是轴上可能有点
        int pre = 0;
        for (int[] h : height) {
            if (h[1] < 0) queue.offer(-h[1]);
            else queue.remove(h[1]);//说明对应的之前已经处理掉了
            int cur = queue.peek();
            if (cur != pre) { //防止重复用多次， 比如[3 15]下一个cur还是15，就不会生成7,15
                res.add(new int[]{h[0], cur});
                pre = cur;
            }
        }
        return res;
    }
}

//sweep line 最高是起点，终点是次高点（被包含住的不算）
// 1.找到全部点  2.从左到右，从高到低排序 3.一个个读取，被包含的不读
