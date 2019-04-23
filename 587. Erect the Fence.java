class Solution {
    public int[][] outerTrees(int[][] points) {
        Set<int[]> result = new HashSet<>();
        // Find the leftmost point
        int[] first = points[0];
        int firstIndex = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] < first[0]) {
                first = points[i];
                firstIndex = i;
            }
        }
        result.add(first);
        
        int[] cur = first;
        int curIndex = firstIndex;
        do {
            int[] next = points[0];
            int nextIndex = 0;
            for (int i = 1; i < points.length; i++) {
                if (i == curIndex) continue;
                int cross = crossProductLength(cur, points[i], next);
                if (nextIndex == curIndex || cross > 0 || 
                        // Handle collinear points
                        (cross == 0 && distance(points[i], cur) > distance(next, cur))) {
                    next = points[i];
                    nextIndex = i;
                }
            }            // Handle collinear points
            for (int i = 0; i < points.length; i++) {
                if (i == curIndex) continue;
                int cross = crossProductLength(cur, points[i], next);
                if (cross == 0) {
                    result.add(points[i]);
                }
            }

            cur = next;
            curIndex = nextIndex;
            
        } while (curIndex != firstIndex); //知道重复，说明形成闭环
        
        List<int[]> list = new ArrayList<int[]>(result);
        
        int[][] res = new int[result.size()][2];
        for (int i = 0 ; i < res.length; i++) {
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
    
    private int crossProductLength(int[] A, int[] B, int[] C) {
        // Get the vectors' coordinates.
        int BAx = A[0] - B[0];
        int BAy = A[1] - B[1];
        int BCx = C[0] - B[0];
        int BCy = C[1] - B[1];
    
        // Calculate the Z coordinate of the cross product.
        return (BAx * BCy - BAy * BCx);
    }

    private int distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
