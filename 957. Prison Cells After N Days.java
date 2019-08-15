class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) { //因为相当于位运算所以肯定有循环，找几个一个循环，然后简化
        boolean hasCycle = false;
        int cycle = 0, index = 0;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            index = i;
            int[] next = nextDay(cells);
            String str = Arrays.toString(next);
            if (set.contains(str)) {
                hasCycle = true;
                break;
            } else {
                set.add(str);
                cycle++;
            }
            cells = next;
        }
        if (hasCycle) {
            int remain = (N - index) % cycle;
            for (int i = 0; i < remain; i++) cells = nextDay(cells);
        }
        return cells;
    }
    
    private int[] nextDay(int[] cells) {
        int[] res = new int[8];
        res[0] = 0; res[7] = 0;
        for (int i = 1; i <= 6; i++) {
            res[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        }
        return res;
    }
}
