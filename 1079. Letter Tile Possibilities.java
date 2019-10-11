class Solution {
    public int numTilePossibilities(String tiles) {
        int[] chars = new int[26];
        for (char c : tiles.toCharArray()) chars[c - 'A']++;
        return dfs(chars);
    }
    
    private int dfs(int[] chars) {
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) continue;
            chars[i]--;
            sum++; //用一个，不用担心位置，因为后面还要还原，然后从别的字母开始，相当于变换位置
            sum += dfs(chars);
            chars[i]++;
        }
        return sum;
    }
}
