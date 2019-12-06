
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public class Data {
        int index, sum;
    } 
    
    public int[] subarraySumClosest(int[] nums) {
        if(nums.length == 0) return new int[0];
        if(nums.length == 1) return new int[]{0, 0};
        Data[] res = new Data[nums.length];
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res[i] = new Data();
            res[i].index = i;
            res[i].sum = sum;
        }
        
        Arrays.sort(res, new Comparator<Data>() {
            public int compare(Data d1, Data d2) {
                return d1.sum - d2.sum;
            }
            
        });
        
        int min = Integer.MAX_VALUE, left = -1, right = -1;
        
        for(int i = 0; i < res.length - 1; i++) {
            if(Math.abs(res[i].sum - res[i + 1].sum) < min) {
                min = Math.abs(res[i].sum - res[i + 1].sum);
                //left = left + 1, right = right
                left = res[i].index < res[i + 1].index ? res[i].index + 1 : res[i + 1].index + 1;
                right = res[i].index < res[i + 1].index ? res[i + 1].index : res[i].index;
            }
        }
        
        return new int[]{left, right};
    }
 
