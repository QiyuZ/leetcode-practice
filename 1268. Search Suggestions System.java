class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        if (searchWord == null || searchWord.length() == 0) return res;
        Trie root = new Trie();
        for (String p : products) {
            Trie copy = root;
            for (char c : p.toCharArray()) {
                if (copy.children[c - 'a'] == null) copy.children[c - 'a'] = new Trie();
                copy = copy.children[c - 'a'];
                copy.words.add(p);
            }
        }
        for (char c : searchWord.toCharArray()) {
            List<String> cur = new ArrayList<>();
            if (root != null) root = root.children[c - 'a'];
            if (root == null) res.add(cur); //当无法匹配，当前root为null
            else {
               for (String word : new ArrayList<>(root.words)) {
                    cur.add(word);
                    if (cur.size() == 3) break;
                } 
                res.add(cur);
            }    
        }
        return res;
    }
    
    class Trie {
        Trie[] children;
        Set<String> words;
        public Trie() {
            words = new TreeSet<>();
            children = new Trie[26];
        }
    }
}
