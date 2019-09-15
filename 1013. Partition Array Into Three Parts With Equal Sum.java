class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int a : A) sum += a;
        if (sum % 3 != 0) return false;
        int target = sum / 3;
        int cur = 0;
        for (int a : A) {
            if (cur == target) cur = 0;
            cur += a;
        }
        return cur == target || cur == 0; //cur可能是0 因为到了target后，后面的和都是0
    }
}
