class Solution {
    public int minInsertions(String s) {
        if (s == null || s.length() == 0) return 0;
        int needRight = 0, insert = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                needRight += 2;
                if (needRight % 2 == 1) { //means there're one more right ) needed
                    insert++;
                    needRight--;
                }
            } else {
                needRight--;
                if (needRight == -1) { //need add a (
                    insert++;
                    needRight = 1; //set to 1 because there 1 more ), then a left ( means 2 ), so 1 needed
                }
            }
        }
        return insert + needRight;
    }
}
