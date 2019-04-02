class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true; //直接选即可赢
        if(desiredTotal > maxChoosableInteger * (maxChoosableInteger +1 ) / 2) return false; //怎么选也赢不了
        int[] flag = new int[maxChoosableInteger + 1]; //标记是否使用
        return canWinHelp(flag, desiredTotal, new HashMap<String ,Boolean>());
    }
    public boolean canWinHelp(int[] flag,int desiredTotal,HashMap<String,Boolean> map) {
        String key = Arrays.toString(flag);
        if (map.containsKey(key)) return map.get(key);
        for (int i = 1; i < flag.length; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                if (i >= desiredTotal || !canWinHelp(flag, desiredTotal - i, map)) {
                    //选的数比目标大，或者剩下的数会输
                    map.put(key, true); 
                    flag[i] = 0; //换回去
                    return true;
                }
                flag[i] = 0; //换回去
            }
        }
        map.put(key, false);
        return false;
    }
}
