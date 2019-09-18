class Solution {
    public boolean queryString(String S, int N) {
        for (int i = N; i > N / 2; --i) //只用考虑一半，因为另一半肯定在
            if (!S.contains(Integer.toBinaryString(i)))
                return false;
        return true;
    }
}
