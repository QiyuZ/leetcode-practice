class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list; //注意
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (true) {
            for (int i = left; i <= right; i++) list.add(matrix[top][i]); //四个顺序
            top++; //注意每次走到头,要移动到下个开始的位置
            if (left > right || top > bottom) break; //注意每次都要检查，因为每次循环都可能到终止条件
            for (int i = top; i <= bottom; i++) list.add(matrix[i][right]);
            right--;
            if (left > right || top > bottom) break;
            for (int i = right; i >= left; i--) list.add(matrix[bottom][i]);
            bottom--;
            if (left > right || top > bottom) break;
            for (int i = bottom; i >= top; i--) list.add(matrix[i][left]);
            left++;
            if (left > right || top > bottom) break;
        }
        return list;
    }
}
