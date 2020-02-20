class Solution {
    public int shortestWay(String source, String target) {
        int i = 0, res = 0;
        while (i < target.length()) {
            int record = i;
            for (int j = 0; j < source.length(); j++) {
                if (i < target.length() && target.charAt(i) == source.charAt(j)) i++; //注意防止已经结束导致越界
            }
            if (record == i) return -1;
            res++;
        }
        return res;
    }
}

class Solution {
    public int shortestWay(String source, String target) {
        int m = source.length();
        int[][] dict = new int[m][26];
        Arrays.fill(dict[m - 1], -1);
        dict[m - 1][source.charAt(m - 1) - 'a'] = m - 1; //dict[i][c - 'a'] 在source中 i位置后面包括i位置，出现c字符的最近一个index是多少
        for (int i = m - 2; i >= 0; i--) {
            dict[i] = Arrays.copyOf(dict[i + 1], 26); //copy后面的
            dict[i][source.charAt(i) - 'a'] = i; //只更新本位置
        }
        int res = 0, index = 0;
        for (char t : target.toCharArray()) {
            if (dict[0][t - 'a'] == -1) return -1; //说明不存在
            if (dict[index][t - 'a'] == -1) { //当前找不到了要返回起始位置
                res++;
                index = 0;
            }
            index = dict[index][t - 'a'] + 1; //找得到更新位置
            if (index == m) { //如果到了头要重置并且计数当前次
                res++;
                index = 0;
            }
        }
        return res + (index == 0 ? 0 : 1); //看要不要计数最后一次
    }
}

