class Solution { //O(nlogk) n = changed.length k = entry in map
    public int[] findOriginalArray(int[] changed) {
        if (changed == null || changed.length == 0 || changed.length % 2 == 1) return new int[0];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int change : changed) map.put(change, map.getOrDefault(change, 0) + 1);
        int[] res = new int[changed.length / 2];
        int index = 0;
        for (int num : map.keySet()) { //treemap from smaller to larger
            if (map.getOrDefault(num * 2, 0) < map.get(num)) return new int[0]; //note they may not be equal as the larger one can be the base num as well
            for (int i = 0; i < map.get(num); i++) {
                res[index++] = num;
                map.put(num * 2, map.get(num * 2) - 1); //reduce one, as it's changed from num. Then when reached to the larger number it's 0 already, so won't continue
            }
        }
        return res;
    }
}

class Solution { //O(m) m = max
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[0];
        // find the max element
        int max = 0;
        for (int num: changed) max = Math.max(max, num);
        // find the frequencies
        int[] freq = new int[max + 1];
        for (int num : changed) freq[num]++;
        // If there is odd number of 0, it's not a duplicate
        if (freq[0] % 2 == 1) return new int[0];
        int[] result = new int[changed.length / 2];
        int index = 0;
        for (int i = 0; i <= max; i++) {
            if (i * 2 > max || freq[i * 2] < freq[i]) return new int[0];
            while (freq[i] > 0) {
                freq[i]--;
                freq[i * 2]--;
                result[index++] = i;
            }
            if (index == result.length) break; //need check to break here, different with line 12
        }

        return result;
    }
}
