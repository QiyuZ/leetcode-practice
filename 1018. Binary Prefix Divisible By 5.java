class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            sum = sum * 2 + A[i];
            sum %= 5; //32位防止越界  (a * b + c) % d = ((a % d) * (b % d) + c % d) % d
            if (sum % 5 == 0) res.add(true);
            else res.add(false);
        }
        return res;
    }
}
