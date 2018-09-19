class WordDictionary {
    Map<Integer, List<String>> map;
    /** Initialize your data structure here. */
    public WordDictionary() {
        map = new HashMap<>();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int index = word.length();
        if (!map.containsKey(index)) map.put(index, new ArrayList<>());
        map.get(index).add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int index = word.length();
        if (!map.containsKey(index)) return false;
        for (String str : map.get(index)) {
            if (match(str, word)) return true;
        }
        return false;
    }
    public boolean match(String str, String word) {
        for (int i = 0; i < str.length(); i++) {
            if (word.charAt(i) != '.' && str.charAt(i) != word.charAt(i)) return false;
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
