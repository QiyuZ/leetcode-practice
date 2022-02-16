class Solution {
    private static final int mod = 1000000007;
    public int numberOfUniqueGoodSubsequences(String binary) {//use append method like that can ensure they are unique
        if (binary == null || binary.isEmpty()) return 0;
        int endWithZero = 0, endWithOne = 0, singleZero = 0; //we consider the single 0 independently as others like 01 0XX is invalid
        for (char c : binary.toCharArray()) {
            if (c == '1') endWithOne = (endWithOne + endWithZero + 1) % mod; //append 1 to previous ones, either ends with 1 or 0, and get a it self
            else {
                endWithZero = (endWithOne + endWithZero) % mod; //because we consider about 1 independently, so don't plus 1
                singleZero = 1; // but assign the value here
            }
        }
        return (endWithZero + endWithOne + singleZero) % mod;
    }
}
