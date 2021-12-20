class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr == null || arr.length == 0) return res;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) min = Math.min(min, Math.abs(arr[i + 1] - arr[i]));
        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i + 1] - arr[i]) == min) res.add(Arrays.asList(arr[i], arr[i + 1]));
        }
        return res;
    }
}

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minPairDiff = Integer.MAX_VALUE;
        List<List<Integer>> answer = new ArrayList();
        for (int i = 0; i < arr.length - 1; ++i) {
            int currPairDiff = arr[i + 1] - arr[i];
            if (currPairDiff == minPairDiff) {
                answer.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (currPairDiff < minPairDiff) {
                answer.clear();
                answer.add(Arrays.asList(arr[i], arr[i + 1]));
                minPairDiff = currPairDiff;
            }
        }
        return answer;   
    }
}
