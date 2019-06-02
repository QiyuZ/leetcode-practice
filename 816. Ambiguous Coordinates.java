class Solution {
    public List<String> ambiguousCoordinates(String S) {
        List<String> res = new ArrayList<>();
        if (S == null || S.length() < 1) return res;
        S = S.substring(1, S.length() - 1);
        for (int i = 1; i < S.length(); i++) {
            List<String> left = find(S.substring(0, i));
            List<String> right = find(S.substring(i));
            for (String l : left) {
                for (String r : right) res.add("(" + l + ", " + r + ")");
            }
        }
        return res;
    }
    
    private List<String> find(String s) {
        int l = s.length();
        char[] cs = s.toCharArray();
        List<String> res = new ArrayList<>();
        if (cs[0] == '0' && cs[l - 1] == '0') { //"0xxx0" 无法形成有效数字除非只是一个0
            if (l == 1) res.add("0");
            return res;
        }
        if (cs[0] == '0') { // 0xxx，只能0.xxx
            res.add("0." + s.substring(1));
            return res;
        }
        if (cs[l - 1] == '0') { //xxx0, 只能本身因为题目说0.10这种invalid
            res.add(s);
            return res;
        }
        for (int i = 1; i < l; i++) { //xxx 可以正常x.xx, xx.x 
            res.add(s.substring(0, i) + "." + s.substring(i));
        }
        res.add(s);//别忘了加上itself
        return res;
    }
}
