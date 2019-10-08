class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length, i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : barcodes) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a))); //可以用map.value来排序
        queue.addAll(map.keySet());
        while (!queue.isEmpty()) {
            int key = queue.poll();
            int freq = map.remove(key);
            while(freq > 0) {
                if (i >= n) i = 1; //此处注意，最多到达一次尽头，因为是隔一个填充的
                res[i] = key;
                i += 2;
                freq--;
            }
        }
        return res;
    }
}
