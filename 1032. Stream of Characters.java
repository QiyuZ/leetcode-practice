class StreamChecker {
    
    private StringBuilder sb;
    private Trie root;
    
    public StreamChecker(String[] words) {
        sb = new StringBuilder();
        root = new Trie();
        buildTrie(words);
    }
    
    public boolean query(char letter) { //query相当于是从后向前看n个字母,所以此处从后往前搜索
        sb.append(letter);
        Trie copy = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (copy.children[c - 'a'] == null) return false;
            copy = copy.children[c - 'a'];
            if (copy.isWord) return true;
        }
        return false;
    }
    
    private void buildTrie(String[] words) { //建立trie时，也要从后往前，这样才不会被depth影响,比如如果正方向build，abcd和jk深度不同
        for (String word : words) {
            Trie copy = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (copy.children[c - 'a'] == null) copy.children[c - 'a'] = new Trie();
                copy = copy.children[c - 'a'];
            }
            copy.isWord = true;
        }
    }
    
    class Trie {
        private Trie[] children;
        private boolean isWord;
        public Trie() {
            this.children = new Trie[26];
            this.isWord = false;
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
