class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                //此处只用查substring(0, word.length() - 1)， 因为只有符合这种层层递进的才能进set如果前一个有，前面的就都有
                set.add(word);
                res = word.length() > res.length() ? word : res;
            }
        }
        return res;
    }
}
