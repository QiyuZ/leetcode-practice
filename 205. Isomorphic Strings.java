class Solution {
    public boolean isIsomorphic(String s, String t) { //标记每个字母的位置，比较当前两个字母是否有相同位置上一位，如果不相同说明不是同一个
        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i), cht = t.charAt(i);
            if (!mapS.containsKey(chs)) mapS.put(chs, -1);//不能放0因为有0 index
            if (!mapT.containsKey(cht)) mapT.put(cht, -1);
            if (!mapS.get(chs).equals(mapT.get(cht))) return false; //注意integer超过128不可以==，会比较地址，要用intValue或equals
            mapS.put(chs, i);
            mapT.put(cht, i);
        }
        return true;
    }
}
