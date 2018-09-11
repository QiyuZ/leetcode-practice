class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        if (n == 0) return tasks.length;
        int[] count = new int[26];
        int max = 0, cnt = 0;
        for (char c : tasks) {
            count[c - 'A']++;
            max = Math.max(max, count[c - 'A']);
        }
        for (int num : count) {
            if (num == max) cnt++;
        }
        return Math.max(tasks.length, (max - 1) * (n + 1) + cnt); //最长的决定长度
        //有几个空*(n+自身)+最长的可能不止一个所以要排布在开头（一个）和最后，如下面例子
        //A、 -> B -> idle -> A -> B -> idle -> A -> B、.  、就是cnt的作用
        
    }
}
