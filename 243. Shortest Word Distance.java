class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int index = -1, res = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && !words[index].equals(words[i])) res = Math.min(res, i - index); //防止更新到相同的比如add
                index = i; //不是else, 只要是目标word就一直保持更新index
            }
        }
        return res;
    }
}


class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) return 0;
        int a = -1, b = -1, res = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) a = i;
            else if (words[i].equals(word2)) b = i;
            if (a != -1 && b != -1) res = Math.min(res, Math.abs(a - b));
        }
        return res;
    }
}
