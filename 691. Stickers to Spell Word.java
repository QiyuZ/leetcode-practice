class Solution {
    public int minStickers(String[] stickers, String target) {
        int min = 0;
        if (target == null || target.length() == 0) return min;
        Queue<int[]> queue = new LinkedList<>();
        int[] tMap = new int[26];
        for (int i = 0; i < target.length(); i++) { // construct map for target
            tMap[target.charAt(i) - 'a']++;
        }
        int sLen = stickers.length;
        int[][] sMap = new int[sLen][26]; //stickers map
        for (int i = 0; i < sLen; i++) { // construct map for stickers
            for (int j = 0; j < stickers[i].length(); j++) {
                sMap[i][stickers[i].charAt(j) - 'a']++;
            }
        }
        queue.offer(tMap);
        Set set = new HashSet<>(); // record left over substring we've already spelled
        while (!queue.isEmpty()) {
            min++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                String curString = toString(cur);
                if (set.add(curString)) { //避免重复
                    for (int j = 0; j < sLen; j++) { //尝试每一个sticker
                        if (sMap[j][curString.charAt(0) - 'a'] == 0) continue; //默认从左一个个开始，如果不符合就下一个
                        int[] temp = cur.clone();
                        for (int k = 0; k < 26; k++) {
                            if (temp[k] > 0) {  // only update temp when the current sticker has the char
                                temp[k] = temp[k] - sMap[j][k];  
                            }
                        }
                        if (couldSpell(temp)) return min;
                        queue.offer(temp);
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean couldSpell(int[] temp) {
        for (int t : temp) {
            if (t > 0) return false;
        }
        return true;
    }
    
    private String toString(int[] word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < word[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return sb.toString();
    }
}
