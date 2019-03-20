// class Solution {
//     public int integerReplacement(int n) {
//         if (n == 1) return 0;
//         Queue<Long> queue = new LinkedList<>();
//         queue.offer((long)n);
//         int level = 0;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 long cur = queue.poll();
//                 if (cur == 1) return level;
//                 if (cur % 2 == 0) queue.offer(cur / 2);
//                 else {
//                     queue.offer(cur + 1);
//                     queue.offer(cur - 1);
//                 }
//             }    
//             level++;
//         }
//         return -1;
//     }
    
// }

class Solution {
    public int integerReplacement(int n) {
        int res = 0;
        while(n != 1){
            if((n & 1) == 0) n >>>= 1;  //偶数直接除2
            else if(n == 3 || ((n >>> 1) & 1) == 0) n--; 
            //看末尾是01还是11，前者-1后者+1，使得0尽量多
            //1=01，所以如果n末尾是01则 n >>> 1 最后一位为0，则=0
            else n++;
            res++;
        }
        return res;
    }
}
