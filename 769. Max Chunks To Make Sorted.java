class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) return 0;  
        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]); //相当于找每个chunk最大的那个数
            if (max == i) { //当max==i即它该在的位置，说明这个chunk完结，因为分chunk其实是看最大的，或者从右开始找最小的
                count++;
            }
        }
        
        return count;
    }
}

/*
1 0 2 3 4
1 0 0 0 0
*/
