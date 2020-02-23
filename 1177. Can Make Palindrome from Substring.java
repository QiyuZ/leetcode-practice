// class Solution {
//     public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
//         List<Boolean> res = new ArrayList<>();
//         if (queries == null || queries.length == 0) return res;
//         for (int[] q : queries) {
//             res.add(canMakePalidrome(q, s));
//         }
//         return res;
//     }
    
//     private boolean canMakePalidrome(int[] q, String s) {
//         if (q[2] >= s.length() / 2 || q[2] >= 13 || q[0] == q[1]) return true;
//         int[] record = new int[26];
//         for (int i = q[0]; i <= q[1]; i++) {
//             if (record[s.charAt(i) - 'a'] == 1) record[s.charAt(i) - 'a'] = 0;
//             else record[s.charAt(i) - 'a'] = 1;
//         }
//         int count = 0;
//         for (int c : record) count += c;
//         return q[2] >= count / 2;
//     }
// }

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        if (queries == null || queries.length == 0) return res;
        int[][] map = new int[s.length()][26]; //每个位置上之前字母出现的情况，包含本位置字母，形成map不用每次都要走一遍
        int[] record = new int[26];
        record[s.charAt(0) - 'a']++;
        map[0] = record;
        for (int i = 1; i < s.length(); i++) {
            map[i] = Arrays.copyOf(map[i - 1], 26);//保持上个位置的
            map[i][s.charAt(i) - 'a']++; //并且更新本位置
        }
        for (int[] q : queries) {
            res.add(canMakePalidrome(q, s, map));
        }
        return res;
    }
    
    private boolean canMakePalidrome(int[] q, String s, int[][]map) {
        int left = q[0], right = q[1], max = q[2];
        if (max >= s.length() / 2 || max >= 13 || left == right) return true;
        int count = 0;
        if (left == 0) {
            for (int c : map[right]) { //left==0 那么map[right]记录的就是全部的
                count += c % 2 == 0 ? 0 : 1;
            }
        } else {
            int[] temp = Arrays.copyOf(map[right], 26);
            for (int i = 0; i < 26; i++) temp[i] -= map[left - 1][i]; //否则要减去left之前的字母
            for (int c : temp) {
                count += c % 2 == 0 ? 0 : 1;
            }
        }count / 2
        return max >= count / 2; //可以多出一个字母作为中间的比如abc,只变一个即可cbc,所以是count / 2而不是max * 2
    }
}
