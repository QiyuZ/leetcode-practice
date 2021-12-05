class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new HashSet<>();
        for(int i=0; i < digits.length; i++) {
            if(digits[i] != 0) {
                int first = digits[i];
                for(int j = 0; j < digits.length; j++) {
                    if(j != i) {
                        int second = first * 10 + digits[j];
                        for(int k = 0; k < digits.length; k++) {
                            if(digits[k] %2 ==0 && k != j && k != i) result.add(second * 10 + digits[k]);
                        }
                    }
                }
            }    
        }
        int[] res = result.stream().mapToInt(Number::intValue).toArray();
        Arrays.sort(res);
        return res;
    }
}
