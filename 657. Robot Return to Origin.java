public class Solution {
    public boolean judgeCircle(String moves) {
        int countH = 0, countV = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'L') countH--;
            else if (moves.charAt(i) == 'R') countH++;
            else if (moves.charAt(i) == 'U') countV--;
            else if (moves.charAt(i) == 'D') countV++;
        }
        return countH == 0 && countV == 0;
    }
}
