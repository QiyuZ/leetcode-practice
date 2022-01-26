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

//note, cant use one map to map 2 chars, because duplicate letters will break it, like badc,baba d doesn't exist so it sets d->b, but for t, b has been added already. 
//So we should either check value exists or not, or use the following index check,meaning check both of 2
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;
        int[] sIndex = new int[256], tIndex = new int[256];
        Arrays.fill(sIndex, -1); //fill with -1 as 0 is a valid index
        Arrays.fill(tIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            if (sIndex[s.charAt(i)] != tIndex[t.charAt(i)]) return false; //check if they have same previous letter
            sIndex[s.charAt(i)] = tIndex[t.charAt(i)] = i; 
        }
        return true;
    }
}
