class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx == ty) return false;
        if (sx == tx && sy == ty) return true;
        if (sx > tx || sy > ty) return false;
        if (sx == tx && (ty - sy) % sx == 0) return true; //x 相等， y是后面加上的，即差为若干个sx
        if (sy == ty && (tx - sx) % sy == 0) return true; //同理，y相等， x是可以是加上的，差为若干个xy
        return reachingPoints(sx, sy, tx % ty, ty % tx);
        /*
        首先tx ty不可能相等因为总有一个加一个没加，题目中说了范围
        tx % ty, ty % tx 保证了只有一个数字变化了，即最大的，是逆过程
        */
    }
}

/*
BFS 时间过不了 */
