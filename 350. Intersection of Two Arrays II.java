// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         if (nums1.length == 0 || nums2.length == 0) return new int[0];
//         Map<Integer, Integer> map = new HashMap<>();
//         List<Integer> list = new ArrayList<>();
//         for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
//         for (int num : nums2) {
//             if (map.containsKey(num) && map.get(num) > 0) {
//                 list.add(num);
//                 map.put(num, map.get(num) - 1);
//             }
//         }
//         int[] res = new int[list.size()];
//         for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
//         return res;
//     }
// }

class Solution { //如果排序了怎么做
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, pos = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[pos++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) j++;
            else i++;
        }
        return Arrays.copyOfRange(nums1, 0, pos);
    }
}
