class Solution {
    public int compress(char[] chars) {
        int res = 0, index = 0;
        while(index < chars.length) {
            int count = 0;
            char cur = chars[index];
            while (index < chars.length && chars[index] == cur) {
                index++;
                count++;
            }
            chars[res++] = cur; //不管count是多少，这个都要这样放
            if (count > 1) {
                for (char c : (count + "").toCharArray()) chars[res++] = c; //数组长度正好比最后一个pos多1，所以直接返回res就行
            }
        }
        return res;
    }
}
