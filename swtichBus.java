/* 一个城市的公交车站 比如公车1号到abcd站，公车2号到cefg站。那么a-d就是1，因为只要坐一辆车，a-g就是2，因为要从c那边1号换2号
问一个站到另一个站的最少换乘
*/

class Solution {
    Map<Integer, Bus> map = new HashMap<>();
    public void store (Bus[] buses) {
        for (Bus bus : buses) map.put(bus.id, bus);
    }
    public int swtichBus (Bus[] buses, char start, char target) {
        int res = Integer.MAX_VALUE;
        //Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].stops.contains(start)) queue.offer(new int[] {buses[i].id, 0});
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            Bus bus = map.get(cur[0]);
            int swtich = cur[1];
            //if (visited.contains(bus.id)) continue;
            //visited.add(bus.id);
            if (bus.stops.contains(target)) res = Math.min(res, swtich);
            for (int i = 0; i < buses.length; i++) {
                if (bus == buses[i]) continue;
                if (hasoverlap(bus, buses[i])) queue.offer(new int[] {buses[i].id, swtich + 1});
            }
        }
        return -1;
    }
    public boolean hasoverlap (Bus a, Bus b) {
        for (char stop : a.stops) {
            if (b.stops.contains(stop)) return true;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
class Bus{
    int id;
    Set<Character> set = new HashSet<>();
    public bus(int id) {
        this.id = id;
    }
}
