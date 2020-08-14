class CombinationIterator {

    private List<String> iterator;
    private int pointer;
    public CombinationIterator(String characters, int combinationLength) {
        this.iterator = new ArrayList<>();
        this.pointer = 0;
        combinations(characters, 0, "", combinationLength);
    }
    
    public String next() {
        return this.iterator.get(this.pointer++);
    }
    
    public boolean hasNext() {
        return this.pointer < this.iterator.size();
    }
    
    private void combinations(String characters, int index, String cur, int combinationLength) {
        if (cur.length() == combinationLength) {
            iterator.add(cur);
            return;
        }
        for (int i = index; i < characters.length(); i++) {
            combinations(characters, i + 1, cur + characters.charAt(i), combinationLength);//注意啊。。里面是i不是index
        }
    }
}


/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
