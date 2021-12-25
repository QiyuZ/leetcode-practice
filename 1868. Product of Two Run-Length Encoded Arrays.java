class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        if (encoded1 == null || encoded1.length == 0) return new ArrayList<>();
        int i = 0, j = 0;
        List<List<Integer>> res = new ArrayList<>();
        int preProd = 0, preFreq = 0;
        while (i < encoded1.length && j <  encoded2.length) {
            int len = Math.min(encoded1[i][1], encoded2[j][1]), value = encoded1[i][0] * encoded2[j][0];
            if (preProd == value) preFreq += len; //could combine several
            else {
                if (preFreq > 0) res.add(Arrays.asList(preProd, preFreq)); // in case it's the init case, preFreq == 0
                preProd = value;
                preFreq = len;
            }
            encoded1[i][1] -= len;
            encoded2[j][1] -= len;
            if (encoded1[i][1] == 0) i++;
            if (encoded2[j][1] == 0) j++;
        }
        res.add(Arrays.asList(preProd, preFreq)); //dont forget one left
        return res;
    }
}
