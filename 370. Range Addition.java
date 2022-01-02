class Solution { //kind like 1109. Corporate Flight Bookings
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];
        if (updates == null || updates.length == 0) return arr;
        for (int[] update : updates) {
            arr[update[0]] += update[2];
            if (update[1] < length - 1) arr[update[1] + 1] -= update[2]; //add num in start index and minus it in end+1 index because we will accumlate
        }
        for (int i = 1; i < length; i++) arr[i] += arr[i - 1];
        return arr;
    }
}
