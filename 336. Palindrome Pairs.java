class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String left = words[i].substring(0, j);
                String right = words[i].substring(j);
                if (isPalin(left)) { //左边互文，最前面加上右边的反文即可
                    String rightRvs = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(rightRvs) && map.get(rightRvs) != i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(rightRvs));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (isPalin(right)) {
                    String leftRvs = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(leftRvs) && map.get(leftRvs) != i && right.length() != 0) { 
                                                                 //防止当两个word互为反文串，会有4次写可以写到left那儿
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(leftRvs));
                        res.add(list);
                    }
                }
            }
        }
        return res;
    } 
    
    public boolean isPalin(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
