class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            map.putIfAbsent(w, new ArrayList<>());
            map.get(w).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        int i = 0, j = 0, res = Integer.MAX_VALUE;
        while (i < map.get(word1).size() && j < map.get(word2).size()) {
            int index1 = map.get(word1).get(i);//不用考虑有一个会剩下没走完，因为是按照大小走的，会有一个不动
            int index2 = map.get(word2).get(j);
            if (index1 > index2) {
                res = Math.min(res, index1 - index2);
                j++;
            }
            else {
                res = Math.min(res, index2 - index1);
                i++;
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
