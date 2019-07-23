class Solution {
    public List<String> wordSubsets(String[] A, String[] B) { //先处理B 形成union数组在挨个排查，降低了时间复杂度，否则是n2
        int[] union = new int[26];
        for (String b : B) {
            int[] temp = wordCounter(b);
            for (int i = 0; i < 26; i++) union[i] = Math.max(temp[i], union[i]);
        }
        List<String> res = new ArrayList<>();
        for (String a : A) {
            int[] temp = wordCounter(a);
            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (temp[i] >= union[i]) count++;
            } 
            if (count == 26) res.add(a);
        }
        return res;
    }
    
    private int[] wordCounter(String s) {
        int[] res = new int[26];
        for (char c : s.toCharArray()) res[c - 'a']++;
        return res;
    }
}
