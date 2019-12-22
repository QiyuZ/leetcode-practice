class Solution {
    public String[] expand(String S) { //backtracking 分成三部分左中右
        if (S == null || S.length() < 2) return new String[] {S};
        List<String> res = new ArrayList<>();
        int i = S.indexOf("{");
        if (i == -1) res.add(S); //没有可选的就直接加入
        else {
            String left = S.substring(0, i);//没有括号的可以看做是一个
            int j = S.indexOf("}");
            String[] mid = S.substring(i + 1, j).split(",");
            String[] right = expand(S.substring(j + 1));
            for (String w0 : mid) {
                for (String w1 : right) {
                    res.add(left + w0 + w1);
                }
            }
        }
        Collections.sort(res);
        return res.toArray(new String[0]);
    }
}
