class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) list1.add(i * 1000 + j);//根据题目最大length只有30，或者用int[]表示，后面找到x,y坐标差值用string表示key也可以
                if (B[i][j] == 1) list2.add(i * 1000 + j);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : list1) { //因为不知道具体是怎么移动的，所以把位置的相对差值作为key, 看按照这个移动最多能有几个，即重合的
            for (int b : list2) {
                map.put(a - b, map.getOrDefault(a - b, 0) + 1);
            }
        }
        return map.isEmpty() ? 0 : Collections.max(map.values());
    }
}
