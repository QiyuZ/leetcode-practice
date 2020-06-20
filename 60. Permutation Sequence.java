class Solution {
    public String getPermutation(int n, int k) {
        int[] factor = new int[n]; //i个数可以生成factor[i]个序列比如n=3 [0,1,2]这里不用6因为是不会超过6的
        List<Integer> nums = new ArrayList<>();
        factor[0] = 1;
        for (int i = 1; i < n; i++) {
            factor[i] = i * factor[i - 1];
            nums.add(i);
        }
        nums.add(n);
        k--; //从0开始的，比如1,2,3 k=6其实是找出第5个否则6/2=3而nums里面是0,1,2计数的
        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / factor[i - 1];//举例如下
            k -= factor[i - 1] * index;
            sb.append(nums.get(index));
            nums.remove(index);
        }
        return sb.toString();
    }
}
// example:
// n = 4, k = 14:

// We have {1, 2, 3, 4}, find the 14th permutation.
// List out all the permutations:

// 1 + (permutations of 2, 3, 4)
// 2 + (permutations of 1, 3, 4)
// 3 + (permutations of 1, 2, 4)
// 4 + (permutations of 1, 2, 3)

// To find the 14th, we can see it falling to range 3 + (permutations of 1, 2, 4), since 1 + (permutations of 2, 3, 4) and 2 + (permutations of 1, 3, 4) could take the first 2 * (3!) = 12 permutations. 3!即为factor[i - 1]
//So we can know the first number of result is 3.
// k = 13 - 2 * 6 = 1 
// Then the question turn to be a smaller problem.
// {1, 2, 4}, find the 2nd permutation.
// List out all the permutations:
// 1 + (permutations of 2, 4)
// 2 + (permutations of 1, 4)
// 4 + (permutations of 1, 2)

// There are 2! + 2! + 2!, 6 permutation. The 2nd must be in range 1 + (permutations of 2, 4). So we can know the second number of result is 1.

// So the question turn be a smaller problem.
// {2, 4}, find the 2nd permutation. The answer is (4, 2).
// So the final result is (3, 1, 4, 2)
