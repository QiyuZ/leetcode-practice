class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join("-", sentence) + "-"; //note need the last "-", connect tail with head
        int pos = 0;
        for (int i = 0; i < rows; i++) {
            pos += cols;
            while (pos >= 0 && s.charAt(pos % s.length()) != '-') pos--; //we need include a whole word, so it must stop at "-"
            pos++;
        }
        return pos / s.length();
    }
}


class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join("-", sentence) + "-";
        int len = s.length(), count = 0;
        int[] map = new int[len];
        for (int i = 1; i < len; ++i) map[i] = s.charAt(i) == '-' ? 1 : map[i - 1] - 1; 
        //map records where and how many steps to move, like - means we get the whole word, so move to next new word. Otherwise, it's 0 or negative
        for (int i = 0; i < rows; ++i) {
            count += cols;
            count += map[count % len];
        }
        return count / len;
    }
}
