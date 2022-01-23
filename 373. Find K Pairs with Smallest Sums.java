public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) { //O(klogk) space O(k)
        List<List<Integer>> res = new ArrayList<>();  
        if (nums1 == null || nums1.length == 0 || nums2.length == 0 || nums2 == null || k == 0) return res;
        Queue<int[]> que = new PriorityQueue<int[]>((a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]])); //sort by sum
        for(int i = 0; i < nums1.length && i < k; i++) que.offer(new int[]{i, 0}); //we add k amount nums1, use third value to count index of nums2, as we only need k, so at most k amount needed for each of them
        while(k > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(Arrays.asList(nums1[cur[0]], nums2[cur[1]]));
            if(cur[1] < nums2.length - 1) que.offer(new int[]{cur[0], cur[1] + 1});
            k--;
        }
        return res;
    }
}

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) { ////O(klogk) space O(n * m) too much memory needed
        List<List<Integer>> res = new ArrayList<>();  
        if (nums1 == null || nums1.length == 0 || nums2.length == 0 || nums2 == null || k == 0) return res;
        Queue<int[]> heap = new PriorityQueue<int[]>((a, b) -> (nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]));
        boolean[][] visited = new boolean[nums1.length][nums2.length];
        heap.add(new int[] {0, 0});  
        visited[0][0] = true; //there will be duplicate like [1,3] -> [2,3] and [2,2] -> [2,3]
        while(!heap.isEmpty() && res.size() < k) {  
            int d[] = heap.poll();  
            res.add(Arrays.asList(nums1[d[0]], nums2[d[1]]));  
            if (d[1] + 1 < nums2.length && !visited[d[0]][d[1] + 1]) {
                heap.add(new int[] {d[0], d[1] + 1});  
                visited[d[0]][d[1] + 1] = true;
            }
            if (d[0] + 1 < nums1.length && !visited[d[0] + 1][d[1]]) {
                heap.add(new int[] {d[0] + 1, d[1]});  
                visited[d[0] + 1][d[1]] = true;
            }
        }  
        return res;  
    }
}
