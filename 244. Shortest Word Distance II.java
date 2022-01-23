class WordDistance {
    private Map<String, List<Integer>> map;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        for (int i = 0; i < wordsDict.length; i++) {
            if (!map.containsKey(wordsDict[i])) map.put(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        if (!map.containsKey(word1) || !map.containsKey(word2)) return -1;
        List<Integer> word1Index = map.get(word1), word2Index = map.get(word2);
        int i = 0, j = 0, res = Integer.MAX_VALUE;
        while (i < word1Index.size() && j < word2Index.size()) { //end when one of it ends because it still move forward, the diff will be larger
            int index1 = word1Index.get(i), index2 = word2Index.get(j);
            res = Math.min(res, Math.abs(index1 - index2)); //move smaller one forward to try to get closer
            if (index1 < index2) i++;
            else j++;
        }
        return res;
    }
}

//what if call shortest1 mill of times, we can preprocess first
class WordDistance {
    private HashMap<String, Integer> map1;
    public WordDistance(String[] words) {
        map1 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!words[i].equals(words[j])) {
                    String st = "";
                    if (words[i].compareTo(words[j]) < 0) st = words[i] + words[j];
                    else st = words[j] + words[i];
                    if (map1.containsKey(st)) map1.put(st, Math.min(map1.get(st), Math.abs(i - j)));
                    else map1.put(st, Math.abs(i - j));
                }
            }
        }
    }

    public int shortest(String word1, String word2) {
        if (word1.compareTo(word2) < 0) return map1.get(word1 + word2);
        return map1.get(word2 + word1);
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
