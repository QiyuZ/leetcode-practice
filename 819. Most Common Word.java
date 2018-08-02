class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for (String ban : banned) if (map.containsKey(ban)) map.remove(ban);
        String res = null;
        for (String word : map.keySet()) {
            if (res == null || map.get(word) > map.get(res)) res = word;
        }
        return res;
    }
}
