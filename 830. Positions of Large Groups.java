class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        if (S == null || S.length() < 3) return res;
        int start = 0, end = 0;
        while (start < S.length() && end < S.length()) {
            while (end < S.length() && S.charAt(start) == S.charAt(end)) end++;
            if (end - start >= 3) res.add(Arrays.asList(start, end - 1));
            start = end;
        }
        return res;
    }
}
