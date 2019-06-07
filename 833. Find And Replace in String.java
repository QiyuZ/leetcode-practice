class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < indexes.length; i++) {
            if (S.substring(indexes[i], indexes[i] + sources[i].length()).equals(sources[i])) map.put(indexes[i], i); 
            //indexes可能不是按照顺序排的，所以记录被换掉S的位置i和在indexes中的位置
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < S.length()) {
            if (map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length(); //跳过length的字母因为已经被覆盖了，注意此处如用for不可以i++,因为会多跳一次
            }
            else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
