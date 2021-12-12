// class Solution {
//     public int maxTotalFruits(int[][] fruits, int startPos, int k) {
//         int left = 0, right = 0, start = 0;
//         //step - fruits
//         TreeMap<Integer, Integer> leftTurnBack = new TreeMap<>(), endRight = new TreeMap<>(); 
//         TreeMap<Integer, Integer> rightTurnBack = new TreeMap<>(), endLeft = new TreeMap<>();
//         int mid = Integer.MIN_VALUE;
//         for (int i = 0; i < fruits.length; i++) {
//             if (fruits[i][0] > startPos) {
//                 mid = i - 1;
//                 break;
//             }
//         }
//         mid = mid == Integer.MIN_VALUE ? fruits.length - 1 : mid;
//         for (int i = mid; i >= 0; i--) {//left
//             int pos = fruits[i][0], amount = fruits[i][1];
//             if (pos == startPos) start = amount;
//             else if (pos + k >= startPos) {
//                 left += amount;
//                 leftTurnBack.put(2 * (startPos - pos), left);
//                 endLeft.put(startPos - pos, left);
//             }
            
//         }
//         int rightAmount = 0;
//         for (int i = mid + 1; i < fruits.length; i++) {
//             int pos = fruits[i][0], amount = fruits[i][1];
//             if (pos == startPos) start = amount;
//             else if (startPos + k >= pos) {
//                 right += amount;
//                 rightTurnBack.put(2 * (pos - startPos), right);
//                 endRight.put(pos - startPos, right);
//             }
//         }
//         if (left == 0 && right == 0) return start;
//         if (left == 0 || right == 0) return Math.max(left, right) + start;
//         int leftRight = 0, rightLeft = 0;;
//         for (int i = 1; i < k; i++) {
//             Integer leftFirstStep = leftTurnBack.floorKey(i), rightEndStep = endRight.floorKey(k - i);
//             if (leftFirstStep != null && rightEndStep != null) {
//                 leftRight = Math.max(leftRight, leftTurnBack.get(leftFirstStep) + endRight.get(rightEndStep));
//             }
//             Integer rightFirstKey = rightTurnBack.floorKey(i), leftEndKey = endLeft.floorKey(k - i);
//             if (rightFirstKey != null && leftEndKey != null) {
//                 rightLeft = Math.max(rightLeft, rightTurnBack.get(rightFirstKey) + endLeft.get(leftEndKey));
//             }
//         }
//         int res = Math.max(left, Math.max(right, Math.max(leftRight, rightLeft)));
//         return res + start;
//     }
// }

class Solution {
    
    public int maxTotalFruits(int[][] f, int pos, int k) { //sliding window
        int l = 0, sum = 0, max_sum = 0;
        while (l < f.length && f[l][0] + k < pos) l++; //find the left one
        for (int r = l; r < f.length && f[r][0] <= pos + k; r++) {
            sum += f[r][1];
            while(Math.min(2 * (pos - f[l][0]) + (f[r][0] - pos), 2 * (f[r][0] - pos) + (pos - f[l][0])) > k) sum -= f[l++][1]; 
            //if the current window is valid (either go left or right and then turn back). We dont need to consider about only left or right here because it will be included when l = pos, just a corner case
            max_sum = Math.max(max_sum, sum);
        }
        return max_sum;
    }
    
}
