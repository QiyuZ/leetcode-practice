/**
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */
//solution1 每一行binary search更新最小 O(mlogn)
class Solution { //从右上角开始，1就向左，因为找最小，0就向下因为可能下面有最小；或者右下角开始左上方走 O(logmn)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if (binaryMatrix == null) return 0;
        List<Integer> matrix = binaryMatrix.dimensions();
        int row = matrix.get(0), col = matrix.get(1);
        int x = 0, y = col - 1;
        int res = Integer.MAX_VALUE;
        while (x < row && y >= 0) {
            int num = binaryMatrix.get(x, y);
            if (num == 0) x++;
            else if (num == 1) {
                res = Math.min(y, res);
                y--;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
