class Solution {
    public String convert(String s, int numRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) res[i] = new StringBuilder();
        int index = 0;
        while (index < len) {
            for (int i = 0; i < numRows && index < len; i++ ) res[i].append(c[index++]); //竖着的
            for (int i = numRows - 2; i >= 1 && index < len; i--) res[i].append(c[index++]); //斜着的（中间）
            //be careful of the range, the first one and last one don't need a letter
        }
        for (int i = 1; i < numRows; i++) res[0].append(res[i]);
        return res[0].toString();
    }
} 
