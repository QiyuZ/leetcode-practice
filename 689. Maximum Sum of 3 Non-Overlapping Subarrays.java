    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
      int n = nums.length;
      int[] sums = new int[n];//accumulative sum, help to reduce calculation. 
      int[] left = new int[n], right = new int[n];
      sums[0] = nums[0];
      for(int i = 1; i < n; i++){
        sums[i] = sums[i - 1] + nums[i];
      }
      
      int max = Integer.MIN_VALUE;
      for(int i = k - 1; i < n; i++){
        int sum = sums[i] - sums[i - k + 1] + nums[i - k + 1]; // sum from i to (i - k + 1)
        if(sum > max){
          max = sum;
          left[i] = i - k + 1;
        } else {
          left[i] = left[i - 1];
        }
      }
      
      max = Integer.MIN_VALUE;
      for(int i = n - k; i >= 0; i--){
        int sum = sums[i + k - 1] - sums[i] + nums[i]; // sum from (i + k - 1) to i
        if(sum > max){
          max = sum;
          right[i] = i;
        } else {
          right[i] = right[i + 1];
        }
      }
      
      int[] res = new int[3];
      max = Integer.MIN_VALUE;
      for(int i = k; i <= n - 2 * k; i++){
        int ls = left[i - 1];
        int rs = right[i + k];
        int sum = sums[ls + k - 1] - sums[ls] + nums[ls]; // max sum subarray on the left
        sum += sums[i + k - 1] - sums[i] + nums[i]; // max sum subarray in the middle
        sum += sums[rs + k - 1] - sums[rs] + nums[rs]; // max sum subarray on the right
        if(sum > max){
          max = sum;
          res[0] = ls;
          res[1] = i;
          res[2] = rs;
        }
      }
      return res;
    }
