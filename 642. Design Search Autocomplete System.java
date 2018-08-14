class AutocompleteSystem {

    static class Trie { //字典树通过一个个字母或者空格传递下去，每个node含有句子次数和string具体内容信息
        Trie[] child = new Trie[27];
        int times = 0;
        String s;
        List<Trie> hottest = new ArrayList<>(); //推荐列表
        
        void updateHottest(Trie node) {
            if (!hottest.contains(node)) {
                hottest.add(node);
            }
            Collections.sort(hottest, new Comparator<Trie>(){ //排序推荐
                public int compare(Trie o1, Trie o2) {
                    return o1.times == o2.times ? o1.s.compareTo(o2.s) : o2.times - o1.times;
                }
                
            });
            if (hottest.size() == 4) {
                hottest.remove(3);
            }
        }

    }
    
    int getIdx(char c) {
        return c == ' ' ? 26 : c - 'a';
    }
    
    void insert(String s, int times) { //插入child是空就新建
        List<Trie> stack = new ArrayList<>();
        Trie cur = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = getIdx(s.charAt(i));
            if (cur.child[idx] == null) {
                cur.child[idx] = new Trie();
            }
            cur = cur.child[idx];
            stack.add(cur); //因为排序是按照每个字母来的，所以更新一个字母就要把它放到list里面更新排序
        }
        cur.times += times; //句子完结。更新这个string出现的次数
        cur.s = s;
        for (Trie node : stack) {
            node.updateHottest(cur);
        }
    }
    
    Trie root = new Trie();
    Trie cur = root;
    StringBuilder sb = new StringBuilder();
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            insert(sb.toString(), 1); //插入这个句子，下面重置list和sb
            sb = new StringBuilder();
            cur = root;
            return new ArrayList<>();
        } else {
            sb.append(c);
            cur = cur != null ? cur.child[getIdx(c)] : null;
            if (cur == null) {
                return new ArrayList<>();
            }
            List<String> res = new ArrayList<>();
            cur.hottest.forEach(node -> res.add(node.s));
            return res;
        }
    }
    
}


/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
