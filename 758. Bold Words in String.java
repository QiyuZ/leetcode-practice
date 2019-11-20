class Solution {
    public String boldWords(String[] words, String S) {
        int n = S.length();
        int[] mark = new int[n + 1]; //此处多一位的原因是如果word是单个字母，那么如果不扩展一位，+1 -1的操作都是在本位，无法识别
        for (String word : words) {
            int i = -1;
            while(S.indexOf(word, i + 1) > -1) {
                i = S.indexOf(word, i + 1);
                mark[i]++; //开头+1， 结尾-1
                mark[i + word.length()]--;
            }    
        }
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        for (int i = 0; i <= n; i++) {
            int cur = pre + mark[i];
            if (cur > 0 && pre == 0) sb.append("<b>");  //要判断pre因为可能cur一直持续大于0 好几位， 之前是0现在大于说明从这一位开始变化
            else if (cur == 0 && pre > 0) sb.append("</b>"); //同理，这一位=0之前大于0说明这是结尾，类似于括号
            if (n == i) break;
            sb.append(S.charAt(i));
            pre = cur; //更新pre
        }
        return sb.toString();
    }
}
