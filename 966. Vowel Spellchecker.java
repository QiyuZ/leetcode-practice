class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Map<String, String> cap = new HashMap<>();
        Map<String, String> vowel = new HashMap<>();
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        for (String w : wordlist) {
            String lower = w.toLowerCase();
            String generalVowel = lower.replaceAll("[aeiou]", "-"); //注意此处要用lower的还是先出现的优先，题目说case-insensitive
            if (!cap.containsKey(lower)) cap.put(lower, w); //记录第一个即可
            if (!vowel.containsKey(generalVowel)) vowel.put(generalVowel, w);
        }
        for (int i = 0; i < queries.length; i++) {
            if (words.contains(queries[i])) continue;
            String lower = queries[i].toLowerCase();
            String generalVowel = lower.replaceAll("[aeiou]", "-");
            if (cap.containsKey(lower)) queries[i] = cap.get(lower);
            else if (vowel.containsKey(generalVowel)) queries[i] = vowel.get(generalVowel);
            else queries[i] = "";
        }
        return queries;
    }
}
/**
比如例子中["KiTe","kite","hare","Hare"]
["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
除非直接包含否则都是第一个KiTe， hare起作用
**/
