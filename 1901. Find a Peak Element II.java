class Solution {
    public int[] findPeakGrid(int[][] mat) { //same as 162. Find Peak Element, but just find max in the row
        if (mat == null || mat.length == 0) return new int[] {-1, -1};
        int m = mat.length;
        int n = mat[0].length;
        int low = 0, high = m - 1, maxIdx = 0;
        while(low < high) {
            int mid = (low + high) / 2;
            maxIdx = findMax(mat[mid]); //make sure it's the largest one in the row
            if(mat[mid][maxIdx] < mat[mid + 1][maxIdx]) low = mid + 1; //and find the peek in the col
            else high = mid;
        }
		maxIdx = findMax(mat[low]);
        return new int[]{low, maxIdx};
    }
    
    private int findMax(int[] arr) {
        int index = 0, max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }
}
