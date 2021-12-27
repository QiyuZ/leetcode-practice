class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) { //Union find O(lm*logn) worst case
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        boolean[] res = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int firstParent = findParent(parent, requests[i][0]), secondParent = findParent(parent, requests[i][1]);
            if (firstParent == secondParent) { //if they have same root, then it means their parent has been verified before, just continue
                res[i] = true;
                continue;
            }
            boolean flag = true;
            
            for (int j = 0; j < restrictions.length; j++) {//Need another union find for restrictions, since the restriction could be part of the chain
                int firstRestriction = findParent(parent, restrictions[j][0]), secondRestriction = findParent(parent, restrictions[j][1]);
                if ((firstParent == firstRestriction && secondParent == secondRestriction) || (firstParent == secondRestriction && secondParent == firstRestriction)) { //Note 2 cases
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res[i] = true;
                parent[secondParent] = firstParent;
            }
        }
        return res;
    }
    
    private int findParent(int[] parent, int index) {
        if (parent[index] == index) return index;
        return findParent(parent, parent[index]);
    }
}
