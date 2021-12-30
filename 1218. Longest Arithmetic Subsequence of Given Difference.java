class Solution {
    public int longestSubsequence(int[] arr, int difference) { //dp actually
        if (arr == null || arr.length < 2) return 0;
        Map<Integer, Integer> map = new HashMap<>(); //num to len of subseq meets the requirement
        int res = 0;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num - difference, 0) + 1);
            res = Math.max(res, map.get(num));
        }
        return res;
    }
}
