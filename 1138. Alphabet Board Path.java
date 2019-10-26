class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        char start = 'a';
        for (char d : target.toCharArray()) {
            int dx = (d - 'a') / 5, sx = (start - 'a') / 5;
            int dy = (d - 'a') % 5, sy = (start - 'a') % 5;
            if (dy < sy) {
                for (int j = sy - dy; j > 0; j--)  sb.append('L'); //L,D一组因为z在左下角落，所以别的去z要先左再下
            }
            if (dx > sx) {
                for (int j = dx - sx; j > 0; j--)  sb.append('D');
            }
            if (dx < sx) {
                for (int j = sx - dx; j > 0; j--)  sb.append('U'); //U,R一组因为z在左下角落，所以当z去别的要先上去，再向右
            }
            if (dy > sy) {
                for (int j = dy - sy; j > 0; j--)  sb.append('R');
            }

            sb.append('!');
            start = d;
        }
        return sb.toString(); //LD,UR这两大组顺序是无所谓的，因为只有一个会发生
    }
}
