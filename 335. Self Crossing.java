class Solution {
    public boolean isSelfCrossing(int[] x) {
        int len = x.length;
        if (len < 4) return false;
        for (int i = 3; i < len; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true; //形成四条线的
            if (i >= 4) {
                if (x[i] + x[i - 4] >= x[i - 2] && x[i - 1] == x[i - 3]) return true; //5条的
            }
            if (i >= 5) {
                if (x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] + x[i - 5] >= x[i - 3] && x[i - 1] < x[i - 3]) return true; //6条的
            }
        }
        return false;
    }
}
/*
------
|    |
|    |
|----------   (a) x[0]>=x[2]&&x[3]>=x[1];

-------
|      |
|      -
|      |
|      | 
|------        (b) x[1]==x[3]&&x[0]+x[4]>=x[2];

----------
|        | 
|        |
|     --------------             
|                  | 
|                  |
|------------------      (c)  x[1]<x[3]&&x[4]<x[2]&&x[0]+x[4]>=x[2]&&x[5]+x[1]>=x[3];

*/
