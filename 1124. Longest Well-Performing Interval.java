class Solution {
    public int longestWPI(int[] hours) {
        int score = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hours.length; i++) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1; //如果此时score>0说明从0-i这个数列满足条件，肯定最大
            } else {
                if (!map.containsKey(score)) map.put(score, i); //存入每次score的坐标
                if (map.containsKey(score - 1)) res = Math.max(res, i - map.get(score - 1)); 
                //如果存在score-1那么之差就是满足的因为差=1，举例 66996 第二个6和第三个6
            }
        }
        return res;
    }
}
