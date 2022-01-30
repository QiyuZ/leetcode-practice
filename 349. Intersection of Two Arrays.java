class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[] {};
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        List<Integer> inse = set1.stream().filter(set2::contains).collect(Collectors.toList());
        int[] res = new int[inse.size()];
        int i = 0;
        for (int num : inse) res[i++] = num;
        return res;
    }
}

class Solution { //O(nlogn) but O(1) space
    public int[] intersection(int[] nums1, int[] nums2) {
        // Assume two array are sorted
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (k == 0 || nums1[i] != nums1[k - 1]) nums1[k++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        
        return Arrays.copyOf(nums1, k);
    }
}
