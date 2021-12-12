class Solution {
    public int countPoints(String rings) {
        int[][] record = new int[10][3];
        for (int i = 0; i < rings.length(); i += 2) {
            char color = rings.charAt(i);
            int index = Integer.parseInt(rings.charAt(i + 1) + "");
            if (color == 'R') record[index][0] = 1;
            else if (color == 'G') record[index][1] = 1;
            else if (color == 'B') record[index][2] = 1;
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            boolean add = true;
            for (int n : record[i]) {
                if (n == 0) add = false;
            }
            if (add) res++;
        }
        return res;
    }
}
