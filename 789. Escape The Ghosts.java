class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int myDist = Math.abs(target[0] - 0) + Math.abs(target[1] - 0);
        for (int[] ghost : ghosts) {
            int ghostDist = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]);
            if (ghostDist < myDist) return false;
        }
        return true;
    }
}

//Manhattan Distance 如果ghost能先到target那么一定能抓住他
