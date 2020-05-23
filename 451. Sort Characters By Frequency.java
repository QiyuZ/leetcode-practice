class Solution {
    public String frequencySort(String s) { //same as 347 PriorityQueueO(nlogm) bucket sort O(n)
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        List<Character>[] list = new ArrayList[s.length() + 1]; //最长可以全是相同的所以+1
        for (char key : map.keySet()) {
            int freq = map.get(key);
            if (list[freq] == null) list[freq] = new ArrayList<>();
            list[freq].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--){
            if (list[i] == null) continue;
            for (char c : list[i]) {
                for (int count = 0; count < i; count++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
