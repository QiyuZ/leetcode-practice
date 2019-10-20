class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] map = new int[1001];
        for (int num : arr1) map[num]++;
        int i = 0;
        for (int num : arr2) {
            while (map[num] > 0) {
                arr1[i++] = num;
                map[num]--;
            }
        }
        for (int j = 0; j < map.length; j++) { //注意此时不能检查arr1因为原来的已经被覆盖了
            while (map[j] > 0) {
                arr1[i++] = j;
                map[j]--;
            }
        }
        return arr1;
    }
}
