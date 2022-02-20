class Solution {
    public int minSumOfLengths(int[] arr, int target) { //this fits the case when there's negative number, kind like 560
        if (arr == null || arr.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>(); //sum - index
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { //record preSum and index
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        int size = arr.length + 1, res = arr.length + 1;//note if we set size as MAX_VALUE the line 16 may overflow
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) size = Math.min(size, i - map.get(sum - target)); //find the subarray from the previous index to current one
            if (map.containsKey(sum + target)) res = Math.min(res, size + map.get(sum + target) - i); //from the current index to next one, this avoid overlap
        }
        return res == arr.length + 1 ? -1 : res;
    }
}


class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        if (arr == null || arr.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, n = arr.length, res = n + 1;
        map.put(0, -1);
        int[] min = new int[n];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            min[i] = i > 0 ? min[i - 1] : n + 1;
            if (map.containsKey(sum - target)) {
                int pre = map.get(sum - target);
                min[i] = Math.min(min[i], i - pre);
				// if pre equals -1 means we only get one sub-array whoes sum eqauls target
                if (pre != -1 && min[pre] != n + 1) res = Math.min(res, min[pre] + i - pre);
            }
            map.put(sum, i);
        }
        return res == n + 1 ? -1 : res;
    }
}

class Solution { //note this only works when all elements >= 0
   public int minSumOfLengths(int[] arr, int target) {
       if (arr == null || arr.length == 0) return 0;
       int n = arr.length;
       int[] best = new int[n];
       Arrays.fill(best, n + 1);
       int sum = 0, start = 0, ans = n + 1, bestSoFar = n + 1;
       for(int i = 0; i < n; i++){
           sum += arr[i];
           while(sum > target) sum -= arr[start++];
           if(sum == target){
               int cur = i - start + 1;
               if(start > 0 && best[start - 1] != n + 1) ans = Math.min(ans, best[start - 1] + cur); //first subarray exists
               bestSoFar = Math.min(bestSoFar, cur); //update current one
           }
           best[i] = bestSoFar;
       }
       return ans == n + 1 ? -1 : ans;
   }
}
