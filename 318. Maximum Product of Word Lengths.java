class Solution {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 0) return 0;
        int n = words.length;
        int[] mark = new int[n];
        //用hashmap做时间会超，所以用二进制的方法，26位不超过int 32位，
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                //这一步很重要，对应移动1的位置再和原来的整合，比如abd就是1011，这样后面方便找重复
                mark[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                //如果等于0说明没有重复的
                if ((mark[i] & mark[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}
