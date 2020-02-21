class Solution {
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
           if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }
        return new HashSet<Character>(map.values()).size() < 26; //不可以有环，否则之前变化的就有变成别的了
    }
}
    /*
        此题的对应有以下几个关系:
        1. 一对一，每一个char互相对应转换即可 a->b
        2. 多对一， aabcc,ccdee, a->c, c->e，其实只要有未在target string出现过的char，那么就可以拿来
        作为temp char桥梁，比如 a->g->c这样转换就不会同时影响c->e的转换
        3. 一对多，a->f, a->g 这样是绝对不可能的，因为char会被同时影响
        
        另外还有一种特殊情况就是，source和target的unique char的数量是一样的时候，如果此时是26个
        则说明完全不能转换，因为没有extra的temp char作为转换的桥梁
    */
