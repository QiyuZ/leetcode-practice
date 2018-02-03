class Solution {
    public String addBoldTag(String s, String[] dict) {
        int n = s.length();
        int[] mark = new int[n + 1];
        for(String d : dict) {
            //这里每次循环i要初始为-1，否则有时候s中没有dict也会有值
            int i = -1;
            //这里要用while而不是if因为会有重复的比如aaabbcc d = a,b,c,答案是和一起的如果用if会被分隔开因为有的没算上
            while((i = s.indexOf(d, i + 1)) >= 0) {
                mark[i]++;
                mark[i + d.length()]--;
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i <= n; i++) {
            int cur = sum + mark[i];
            if (cur > 0 && sum == 0) sb.append("<b>");
            if (cur == 0 && sum > 0) sb.append("</b>");
            if (i == n) break;
            sb.append(s.charAt(i));
            sum = cur;
        }
        return sb.toString();
    }
}
