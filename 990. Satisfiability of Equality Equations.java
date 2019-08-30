class Solution {
    private int[] uf = new int[26];
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) uf[i] = i;
        for (String e : equations) {
            if (e.charAt(1) == '=') {
                uf[find(e.charAt(0) - 'a')] = find(e.charAt(3) - 'a');
            }
        }
        for (String e : equations) {
            if (e.charAt(1) == '!') {
                if (find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a')) return false;
            }
        }
        return true;
    }
    
    private int find(int i) {
        if (uf[i] == i) return i;
        return find(uf[i]);
    }
}



