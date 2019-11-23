// class Solution {
//     public List<String> removeInvalidParentheses(String s) {
//         List<String> res = new ArrayList<>();
//         if (s == null) return res;
//         Queue<String> queue = new LinkedList<>();
//         Set<String> visited = new HashSet<>();
//         queue.offer(s);
//         visited.add(s);
//         boolean found = false;
//         while (!queue.isEmpty()) {
//             String cur = queue.poll();
//             if (isValid(cur)) {
//                 res.add(cur);
//                 found = true;
//             }
//             if (found) continue; //保证最小的长度
//             for (int i = 0; i < cur.length(); i++) {
//                 char c = cur.charAt(i);
//                 if (c != '(' && c != ')') continue;
//                 String next = cur.substring(0, i) + cur.substring(i + 1);
//                 if (visited.add(next)) queue.offer(next);
//             }
//         }
//         return res;
//     }
    
//     private boolean isValid(String cur) {
//         int count = 0;
//         for (char c : cur.toCharArray()) {
//             if (c == '(') count++;
//             else if (c == ')') count--;
//             if (count < 0) return false;
//         }
//         return count == 0;
//     }
// }

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') {
                if (left > 0) left--; //要先看能不能抵消掉
                else right++;
            }
        }
        dfs(s, 0, left, right, res);
        return res;
    }
    
    private void dfs(String s, int index, int left, int right, List<String> res) {
        if (left == 0 && right == 0 && isValid(s)) { //要检查比如)(就不行
            res.add(s);
            return;
        } 
        for (int i = index; i < s.length(); i++) {
            if (i != index && s.charAt(i) == s.charAt(i - 1)) continue;
            else if (left > 0 && s.charAt(i) == '(') dfs(s.substring(0, i) + s.substring(i + 1), i, left - 1, right, res);
            else if (right > 0 && s.charAt(i) == ')') dfs(s.substring(0, i) + s.substring(i + 1), i, left, right - 1, res);
        }
    }
    
    private boolean isValid(String cur) {
        int count = 0;
        for (char c : cur.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
    
    
    
}
