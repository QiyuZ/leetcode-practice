//O(n^2)
class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        if (n <= 1) return res;
        for (int i = 0; i < s.length(); i++) {
            int count = 0, x = startPos[0], y = startPos[1];
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == 'L') y--;
                else if (c == 'R') y++;
                else if (c == 'U') x--;
                else if (c == 'D') x++;
                if (x >= 0 && x < n && y >= 0 && y < n) count++;
                else break;
            }
            res[i] = count;
        }
        return res;
    }
}

//O(nlogn)
class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] res = new int[s.length()];
        if (n <= 1) return res;
        for (int i = 0; i < s.length(); i++) {
            int count = 0, x = startPos[0], y = startPos[1];
            int left = i, right = s.length() - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isValidMove(startPos, i, mid, s, n)) left = mid + 1;
                else right = mid;
            }
            res[i] = isValidMove(startPos, i, left, s, n) ? left - i + 1 : left - i; //need to double confirm if the last stopped pos is valid or step back by -1
        }
        return res;
    }
    
    private boolean isValidMove(int[] startPos, int start, int end, String s, int n) {
        int x = startPos[0], y = startPos[1];
        for (int j = start; j <= end; j++) {
            char c = s.charAt(j);
            if (c == 'L') y--;
            else if (c == 'R') y++;
            else if (c == 'U') x--;
            else if (c == 'D') x++;
            if (x >= 0 && x < n && y >= 0 && y < n) continue;
            else return false;
        }
        return true;
    }
}
  
