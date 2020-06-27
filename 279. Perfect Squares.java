class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) candidates.add(i * i); //加入所有候选，从1开始
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int count = 0; count < size; count++) {
                int cur = queue.poll();
                for (int cand : candidates) {
                    if (cand < cur) queue.offer(cur - cand); //小的加入差值，即使用这个，加入剩下的值
                    else if (cand == cur) return level;//有一个找到就是最小的
                    else break;//当前已经大了，后面的更大，直接break
                }
            }
        }
        return -1;
    }
}

public class Solution {  
    public int numSquares(int n) {  
        if (n == 0) return 0;
        int[] dp = new int[n + 1];  
        Arrays.fill(dp, Integer.MAX_VALUE);  
        for(int i = 1; i * i <= n; i++)  dp[i * i] = 1;  
        for(int i = 1; i <= n; i++) {  //选定第一个数为 i  
            for(int j = 1; i + j * j <= n; j++) {  //选定另一个数为 j*j  
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //从小到大查找  
                //一个完美平方数一定等于一个完美平方数加上另一个数
                //所以这个时候这个普通数i + j * j包含的完美平方数个数可能就是i+1(1的含义就是j*j)
            }  
        }  
        return dp[n] == Integer.MAX_VALUE ? 0 : dp[n];  
    }  
}  
