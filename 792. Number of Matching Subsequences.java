class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        Set<String> sub = new HashSet<>(), nonSub = new HashSet<>();
        int res = 0;
        for (String w : words) {
            if (sub.contains(w)) {
                res++;
                continue;
            }
            if (nonSub.contains(w)) continue;
            if (isSub(w, S)) {
                sub.add(w);
                res++;
            }
            else nonSub.add(w);
        }
        return res;
    }
    
    private boolean isSub(String word, String S) {
        int index = -1;
        for (char c : word.toCharArray()) {
            index = S.indexOf(c, index + 1); //index一直往后移动
            if (index == -1) return false;
        }
        return true;
    }
}
