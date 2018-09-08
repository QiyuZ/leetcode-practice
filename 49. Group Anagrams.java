class Solution {
    public List<List<String>> groupAnagrams(String[] strs) { //feature类型题，用map， feature做key下面各种变形做value
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] words = new int[26];
            for (char ch : str.toCharArray()) words[ch - 'a']++;
            String key = Arrays.toString(words);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        for (String k : map.keySet()) res.add(map.get(k));
        return res;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        for (List<String> list : map.values()) res.add(list);
        return res;
    }
}
