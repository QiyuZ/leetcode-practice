class MagicDictionary {
    Map<String, Character> map;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        map = new HashMap<String, Character>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String d : dict) {
            StringBuilder sb = new StringBuilder(d);
            for (int i = 0; i <d.length(); i++) {
                sb.setCharAt(i, '*');
                //此处如果key已经存在说明有两个相似单词比如cat,rat都是*at,这时第一个字母可以随意因为cat可以看成是rat的变形
                map.put(sb.toString(), map.containsKey(sb.toString()) ? '*' : d.charAt(i));
                sb.setCharAt(i, d.charAt(i));
            }
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < word.length(); i++) {
            sb.setCharAt(i, '*');
            if (map.containsKey(sb.toString()) && map.get(sb.toString()) != word.charAt(i)) return true;
            sb.setCharAt(i, word.charAt(i));
        }
        return false;
    }
}
//思路就是把每个单词的每个字母替换成*然后存入map，查找时只要value不是原值就行比如war (*ar,w)(w*r, a)(wa*, r)
