class StreamChecker {
    private Trie root;
    private StringBuilder sb;
    public StreamChecker(String[] words) {
        root = new Trie();
        sb = new StringBuilder();
        buildTrie(words);
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        Trie node = root;
        for (int i = sb.length() - 1; i >= 0 && node != null; i--) {
            node = node.children[sb.charAt(i) - 'a'];  //因为头指针没有字母，所以先走到children再看isWord
            if (node != null && node.isWord) return true; //要检查新的是不是null因为可能没有该指针
        }
        return false;
    }
    
    private void buildTrie(String[] words) { //和query都是倒序
        for (String word : words) {
            Trie node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (node.children[c - 'a'] == null) node.children[c - 'a'] = new Trie();
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
    }
    
    class Trie {
        Trie[] children;
        boolean isWord;
        public Trie () {
            children = new Trie[26];
            isWord = false;
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
