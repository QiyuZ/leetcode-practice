class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        if (grid == null || grid.length == 0 || k == 0) return grid;
        int m = grid.length, n = grid[0].length;
        int rt = 0, rb = m - 1, cl = 0, cr = n - 1;
        Queue<Integer> queue = new LinkedList<>();
        while (rt < rb && cl < cr) { //get by closewise order as it goes by counter-closewise order, then move k position and reassign
            int actualK = k % ((rt - rb) * 2 + (cl - cr) * 2); //in case k too large
            for (int i = cl; i < cr; i++) queue.offer(grid[rt][i]); //note all of these wont be = as we need leave the last one the next for loop
            for (int i = rt; i < rb; i++) queue.offer(grid[i][cr]);
            for (int i = cr; i > cl; i--) queue.offer(grid[rb][i]);
            for (int i = rb; i > rt; i--) queue.offer(grid[i][cl]);
            while(actualK-- != 0) queue.offer(queue.poll());
            for (int i = cl; i < cr; i++) grid[rt][i] = queue.poll();
            for (int i = rt; i < rb; i++) grid[i][cr] = queue.poll();
            for (int i = cr; i > cl; i--) grid[rb][i] = queue.poll();
            for (int i = rb; i > rt; i--) grid[i][cl] = queue.poll();
            rt++;
            rb--;
            cl++;
            cr--;
            queue.clear(); //just use one object
        }
        return grid;
    }
}

// public int[][] rotateGrid(int[][] grid, int k) {
//         int rowLow = 0;
//         int rowHigh = grid.length - 1;
//         int colLow = 0;
//         int colHigh = grid[0].length - 1;
//         while(rowLow < rowHigh && colLow < colHigh){
//             int localK = k % ((rowHigh - rowLow) * 2 + (colHigh - colLow) * 2);
//             for(int i  = 0;i<localK;i++){// hard to update k steps in one step, as some may move from row to col. So just rotate localK times
//                 //up row
//                 int temp = grid[rowLow][colLow]; //keep original, as it will be overwritten
//                 for(int j = colLow;j<colHigh;j++){
//                     grid[rowLow][j] = grid[rowLow][j+1];
//                 }
//                 //right col
//                 for(int j = rowLow;j<rowHigh;j++){
//                     grid[j][colHigh] = grid[j+1][colHigh];
//                 }
//                 for(int j = colHigh;j>colLow;j--){
//                     grid[rowHigh][j] = grid[rowHigh][j-1];
//                 }
//                 for(int j = rowHigh;j>rowLow;j--){
//                     grid[j][colLow] = grid[j-1][colLow];
//                 }
//                 grid[rowLow + 1][colLow] = temp;
//             }
//            //shrink one step for inner layer.
//             rowLow++;
//             rowHigh--;
//             colLow++;
//             colHigh--;
//         }
//         return grid;
//     }
