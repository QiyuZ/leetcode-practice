class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        if (source == null || source.length == 0) return res;
        StringBuilder sb = new StringBuilder();
        boolean block = false; //检查有没有被/*
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (block) { //如果被block就一直忽略知道遇到 */
                    if (s.charAt(i) == '*' && (i < s.length() - 1 && s.charAt(i + 1) == '/')) {
                        i++; //前进一位这样下次就到了符号之后
                        block = false; //解封
                    }
                } else {
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') break; //遇到//忽略这一行
                    else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') { //block
                        i++;
                        block = true;
                    } else sb.append(s.charAt(i));
                }
            }
            if (!block && sb.length() > 0) { //block可能跨行，要确认没有block
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return res;
    }
}
