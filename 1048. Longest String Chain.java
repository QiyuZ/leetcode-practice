class Solution {
    public int longestStrChain(String[] words) {
        Set<String> set = new HashSet<>();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            set.add(w);
            count.put(w, 1);
        }
        for (int i = 0; i < words.length; i++) {
            if (i > 0 && words[i].equals(words[i - 1])) continue;
            for (int j = 0; j < words[i].length(); j++) {
                StringBuilder sb = new StringBuilder(words[i]);
                sb.deleteCharAt(j);
                String next = sb.toString();
                if (set.contains(next)) count.put(words[i], Math.max(count.get(words[i]), count.get(next) + 1));
            }
        }
        int res = 0;
        for (int num : count.values()) res = Math.max(res, num);
        return res;
    }
}
