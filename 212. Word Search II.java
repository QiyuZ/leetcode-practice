class Solution {
    
    class Trie {
        Trie[] next = new Trie[26];
        String word;
        public Trie(){}
    }
    
    List<String> res;
    int m, n;
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        m = board.length;
        n = board[0].length;
        Trie root = buildTrie(words);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                dfs(i, j, board, root);
            }
        }
        return res;
    }
    
    public Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie node = root;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Trie(); 
                node = node.next[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }
    
    public void dfs(int i, int j, char[][] board, Trie root) {
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        char cur = board[i][j];
        if (cur == '#' || root.next[cur - 'a'] == null) return; 
        root = root.next[cur - 'a']; //如果上面没有return说明当前存在，移到下一个
        if (root.word != null) {
            res.add(root.word);
            root.word = null;//删除，防止重复
        }
        board[i][j] = '#';
        dfs(i - 1, j, board, root);
        dfs(i + 1, j, board, root);
        dfs(i, j - 1, board, root);
        dfs(i, j + 1, board, root);
        board[i][j] = cur;
    }
    
}
