class Solution {
    public boolean canBeEqual(int[] target, int[] arr) { //if they have same elements with same freq, then they must can be equal
        int[] counts = new int[1001];
        for (int i = 0; i < target.length; i++) {
            counts[arr[i]]++;
            counts[target[i]]--;
        }
        for (int c : counts) {
            if (c != 0) return false;
        }
        return true;
    }
}
