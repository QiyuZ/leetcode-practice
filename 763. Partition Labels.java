class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        for (int i = 0; i < S.length(); i++) map[S.charAt(i) - 'a'] = i; //只需记录最后一个
        int start = 0, last = 0;
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(last, map[S.charAt(i) - 'a']); //每次更新最后那个直到本次就是最后那个
            if (last == i) { 
                res.add(last - start + 1);
                start = last + 1;
            }
        }
        return res;
    }
}
