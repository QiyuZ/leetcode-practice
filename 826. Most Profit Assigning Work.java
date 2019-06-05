class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> works = new ArrayList<>();
        for (int i = 0; i < profit.length; i++) works.add(new int[] {difficulty[i], profit[i]});
        Collections.sort(works, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        Arrays.sort(worker);
        int maxp = 0, res = 0, i = 0;
        for (int w : worker) {
            while (i < works.size() && w >= works.get(i)[0]) 
                maxp = Math.max(maxp, works.get(i++)[1]); //别忘了移动i,因为下一个worker数值更大，所以不用从新比较
            res += maxp;
            //保持一个maxp，如果下一个不必diff大，直接取上一次最大的即可
        }
        return res;
    }
}

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = 100000;
        int[] bucket = new int[n+1];
        
        //tasks with the same difficulty may have different profit
        for (int i = 0; i < difficulty.length; i++) {
            int d = difficulty[i];
            if (bucket[d] < profit[i]) {
                bucket[d] = profit[i];
            } 
        }
        
        int max = 0;
        for (int i = 0; i <= n; i++) {
            if (bucket[i] < max) {
                bucket[i] = max;
            } else {
                max = bucket[i];
            }     
        }
        
        int ret = 0;
        for (int w: worker) {
            ret += bucket[w];
        }
        
        return ret;
    }
}
