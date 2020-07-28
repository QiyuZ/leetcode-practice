class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        int[] records = new int[256];
        for (char task : tasks) records[task - 'A']++;
        int maxFreq = 0, maxCount = 1;//因为可能有多个task频率相同，所以要找出最多出现的个数， 和有几个最多的
        for (int record : records) {
            if (record > maxFreq) {
                maxFreq = record;
                maxCount = 1;
            } else if (record == maxFreq) maxCount++;
        }
        int res = (maxFreq - 1) * (n + 1) + maxCount;
        //        不算结尾 * 加上最多那个的本身 + 如果有多个个数相同的后面则需要都加上， 比如[A,A,A,B,B,B]
        return res < tasks.length ? tasks.length : res;
    }
}
