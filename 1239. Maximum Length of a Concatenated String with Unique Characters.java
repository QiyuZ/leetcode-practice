class Solution {
    private int res = 0;
    public int maxLength(List<String> arr) {
        if (arr == null || arr.isEmpty()) return 0;
        dfs(arr, "", 0);
        return res;
    }
    private void dfs(List<String> arr, String s, int index) {
        res = Math.max(res, s.length());
        if (index == arr.size()) return;
        for (int i = index; i < arr.size(); i++) {
            if(isUnique(s + arr.get(i))) dfs(arr, s + arr.get(i), index + 1);
        }
    }
    public static boolean isUnique(String s){
        Set<Character> set = new HashSet<Character>();
        for(char ch: s.toCharArray()){
            if(!set.add(ch)) return false;
        }
        return true;
    }
}


class Solution {
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) return 0;
        return maxLengthDFS(arr, 0, 0);
    }

    public int maxLengthDFS(List<String> arr, int start, int bitMask) {
        if (start == arr.size()) return 0;
        int ans = 0;
        for (int i = start; i < arr.size(); i++) {
            int bit = getBitMask(arr.get(i));
            if (bit == 0 || (bitMask & bit) != 0) continue;
            //一。当前子字符位掩码不为0（为0的话证明子字符里面有重复字符）
            //二。当前子字符位掩码与前面字符的位掩码与运算结果为0（如果结果不为0，那么说明与之前的字符串有重复）
            //满足上述两个条件才进入一下层递归。
            ans = Math.max(ans, maxLengthDFS(arr, i + 1, bitMask | bit) + arr.get(i).length());
        }
        return ans;
    }

    public int getBitMask(String s) {
        int bitMask = 0;
        for (char c : s.toCharArray()) {
            int bit = 1 << (c - 'a');
            if ((bit & bitMask) != 0) return 0;
            bitMask |= bit;
        }
        return bitMask;
    }
}
