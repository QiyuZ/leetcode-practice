class Solution {
    public int[] findBuildings(int[] heights) {
        if (heights == null || heights.length == 0) return new int[] {};
        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) res.add(i);
            max = Math.max(max, heights[i]);
        }
        int[] arr = new int[res.size()];
        for (int i = res.size() - 1; i >= 0; i--) arr[i] = res.get(res.size() -1 - i);
        return arr;
    }
}

// class Solution {
//     public int[] findBuildings(int[] heights) {
//         if (heights == null || heights.length == 0) return new int[] {};
//         List<Integer> res = new ArrayList<>();
//         int max = Integer.MIN_VALUE;
//         for (int i = heights.length - 1; i >= 0; i--) {
//             if (heights[i] > max) res.add(0, i);
//             max = Math.max(max, heights[i]);
//         }
//         return res.stream().mapToInt(Integer::intValue).toArray();
//     }
// }
