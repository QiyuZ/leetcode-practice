class Solution {
    public boolean canTransform(String start, String end) {
        int l = 0, r = 0;
        for (int i = 0; i < start.length(); i++) { //说是交换其实可以看做l向左移动，r向右移动
            if (start.charAt(i) == 'L') l++;
            if (start.charAt(i) == 'R') r++;
            if (end.charAt(i) == 'L') l--;
            if (end.charAt(i) == 'R') r--;
            if (l > 0 || r < 0 || (r > 0 && l != 0) || (l < 0 && r != 0)) return false;
            //因为l向左移动所以start中L出现靠后，不可能>0, 同理r不能<0 
            //当r>0说明有r移动，说明下一个end中出现r如果L此时不为0则也要处理L，矛盾； 同理L<0时
        }
        return l == 0 && r == 0; //have same amount of L and R
    }
}
