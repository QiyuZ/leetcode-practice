// class Solution {
//     public int[] corpFlightBookings(int[][] bookings, int n) {
//         int[] map = new int[20001];
//         for (int[] book : bookings) {
//             for (int i = book[0]; i <= book[1]; i++) map[i] += book[2];
//         }
//         int[] res = new int[n];
//         for (int i = 0; i < n; i++) res[i] = map[i + 1];
//         return res;
//     }
// }

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] b : bookings) {
            res[b[0] - 1] += b[2]; //当天需要k seats 要-1因为是从0开始的
            if (b[1] < n) res[b[1]] -= b[2]; //j+1天撤走k个座位
        }
        for (int i = 1; i < n; i++) res[i] += res[i - 1]; //累加
        return res;
    }
}
