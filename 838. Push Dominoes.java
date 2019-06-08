class Solution {
    public String pushDominoes(String dominoes) {
        String s = "L" + dominoes + "R"; //头尾可以特殊考虑，但更好的办法是加上LR这样不会影响头尾的状态，处理时只要不加第一个最后一个字符即可
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 1; j < s.length(); j++) {
            if (s.charAt(j) == '.') continue;
            if (i > 0) sb.append(s.charAt(i)); 
            //每次LR之间的字符已经加上，第一个不加，i的就是原本是LR的字符，由于最后一个到R时不会继续，所以加不上上面那个R
            int mid = j - i - 1; //之间的个数
            if (s.charAt(i) == s.charAt(j)) { //相等不管LR都是一样的
                for (int k = 0; k < mid; k++) sb.append(s.charAt(i));
            } else if (s.charAt(i) == 'L' && s.charAt(j) == 'R') { //两边倒不影响，直接加点
                for (int k = 0; k < mid; k++) sb.append('.'); 
            } else { //中间倒，中间的那个是点（如果是奇数），其他的平分右左倒
                for (int k = 0; k < mid / 2; k++) sb.append('R');
                if (mid % 2 == 1) sb.append('.');
                for (int k = 0; k < mid / 2; k++) sb.append('L');
            }
            i = j; //因为不考虑多个的力，所以每次只找一对即可，见例子2
        }
        return sb.toString();
    }
}
