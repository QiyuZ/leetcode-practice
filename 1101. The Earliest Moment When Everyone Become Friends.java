class Solution {
    public int earliestAcq(int[][] logs, int n) {
        if (logs == null || logs.length == 0 || n <= 0) return -1;
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int[] people = new int[n];
        for (int i = 0; i < n; i++) people[i] = i;
        for (int[] log : logs) {
            int time = log[0], p0 = log[1], p1 = log[2];
            int parent0 = find(people, p0), parent1 = find(people, p1);
            if (parent0 != parent1) {
                n--;
                people[parent0] = parent1; //merge parent
            }
            if (n == 1) return time; //only one parent, which means they are all connected
        }
        return -1;
    }
    
    private int find(int[] people, int i) {
        if (people[i] == i) return i;
        return people[i] = find(people, people[i]);
    }
}
