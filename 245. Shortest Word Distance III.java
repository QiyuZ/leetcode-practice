class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1, res = Integer.MAX_VALUE;
        boolean same = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && (same || !words[index].equals(words[i]))) res = Math.min(res, i - index);
                index = i;
            }
        }
        return res;
    }
}
