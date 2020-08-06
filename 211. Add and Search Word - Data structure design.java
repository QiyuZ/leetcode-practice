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

class WordDictionary {  //better way
    private Trie root, copy;
    /** Initialize your data structure here. */
    public WordDictionary() {
        copy = new Trie();
        root = copy;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        copy = root; //注意add和search都要重置到起点，否则位置都不对
        for (char w : word.toCharArray()) {
            if (copy.children[w - 'a'] == null) copy.children[w - 'a'] = new Trie();
            copy = copy.children[w - 'a'];
        }
        copy.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        copy = root; //每次重置指针的起始点
        return search(word, copy, 0);
    }
    
    private boolean search(String word, Trie root, int index) {
        if (index == word.length()) return root.word != null;
        char cur = word.charAt(index);
        if (cur == '.') {
            for (Trie child : root.children) {//查询a-z，有一个符合即可
                if (child != null && search(word, child, index + 1)) return true;
            }  
            return false;//注意如果都不符合直接false
        } 
        if (root.children[cur - 'a'] == null) return false;
        root = root.children[cur - 'a'];
        return search(word, root, index + 1);
    }
    
    class Trie {
        private Trie[] children;
        private String word; //或者直接用boolean isWord
        public Trie() {
            this.children = new Trie[26];
            this.word = null;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
