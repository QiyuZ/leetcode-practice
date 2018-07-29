class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int index = 0, n = words.length;
        while (index < n) {
            int count = words[index].length();
            int last = index + 1;
            while (last < n) {  //step1 找到这一行有几个单词
                if (words[last].length() + 1 + count > maxWidth) break;  //1是单词间应该有的空格，注意后面append时要加上
                count += 1 + words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]); //先加入头单词（因为前面没有空格）
            int diff = last - index - 1; //step2 看有几个间隔
            if (last == n || diff == 0) { //case 1. last line or just one word in this line, 如果是最后一行不用均分间隔
                for (int i = index + 1; i < last; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int len = sb.length(); len < maxWidth; len++) sb.append(" "); //别忘了结尾加满空格
            } else {  //case 2. 常规情况，考虑如何均分空格
                int spaces = (maxWidth - count) / diff; //平均每个间隔几个空格，但是注意可能有多的
                int remain = (maxWidth - count) % diff;  //remain=多出几个？
                for (int j = index + 1; j < last; j++) {
                    for (int k = spaces; k > 0; k--) sb.append(" ");
                    if (remain > 0) {  //如果有多的，根据左边多的题意，补充一个
                        sb.append(" ");
                        remain--;
                    }
                    sb.append(" "); //这点很重要， 之前有+1，其实是加空格，别忘了算上
                    sb.append(words[j]);
                }
            }
            res.add(sb.toString());
            index = last; //更新一行的头单词
        }
        return res;
    }
}
