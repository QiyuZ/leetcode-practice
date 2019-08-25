class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        char a = 'a', b = 'b';
        int i = A, j = B;
        if (A < B) {
            a = 'b'; b = 'a';
            i = B; j = A;
        }
        while (i > 0) {
            sb.append(a);
            i--;
            if (i > j) { //如果相等就不用继续放原来多的了
                sb.append(a);
                i--;
            }
            if (j > 0) { //不管是相等还是已经放了两个a都要放b了
                sb.append(b);
                j--;
            } 
        }
        return sb.toString();
    }
}
