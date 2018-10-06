class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] workers = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i][0] = (double)wage[i] / quality[i]; //ratio 和quality这样算wage时可直接相乘
            workers[i][1] = (double)quality[i];
        }
        Arrays.sort(workers, (a,b) -> Double.compare(a[0], b[0])); //按照ratio从小到大排序
        PriorityQueue<Double> queue = new PriorityQueue<>((a,b) -> Double.compare(b,a)); //从大到小排quality这样大的会被poll出
        double sum = 0, res = Double.MAX_VALUE;
        for (double[] cur : workers) {
            sum += cur[1];
            queue.offer(cur[1]);
            if (queue.size() > K) sum -= queue.poll();
            if (queue.size() == K) res = Math.min(res, cur[0] * sum);
        }
        return res;
    }
}

//其实就是找到一个合适ratio，ratio太低凑不齐足够的人数，太高不满足花费最少
