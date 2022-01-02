class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (boxTypes == null || boxTypes.length == 0) return 0;
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (truckSize == 0) return res;
            if (boxTypes[i][0] <= truckSize) {
                truckSize -= boxTypes[i][0];
                res += boxTypes[i][1] * boxTypes[i][0];
            } else {
                res += truckSize * boxTypes[i][1];
                break;
            }
        }
        return res;
    }
}
