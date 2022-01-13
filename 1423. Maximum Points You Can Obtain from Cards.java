class Solution {
    public int maxScore(int[] cardPoints, int k) { //the remaining is a sliding window
        if (cardPoints == null) return 0;
        if (k >= cardPoints.length) {
            int res = 0;
            for (int pt : cardPoints) res += pt;
            return res;
        }
        int size = cardPoints.length - k, left = 0, sum = 0, remain = Integer.MAX_VALUE, cur = 0;
        for (int right = 0; right < cardPoints.length; right++) {
            sum += cardPoints[right];
            cur += cardPoints[right];
            if (right - left + 1 > size) cur -= cardPoints[left++];
            if (right - left + 1 == size) remain = Math.min(remain, cur);
        }
        return sum - remain;
    }
}


class Solution {
    public int maxScore(int[] cardPoints, int k) { //[1,2,3,4,5,6,1] from choose 1,2,3 to 1,2...,1 -> 1...,61 -> ....5,6,1
        int frontScore = 0;
        int rearScore = 0;
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) frontScore += cardPoints[i];// take all k cards from the beginning
        int maxScore = frontScore;
        for (int i = k - 1; i >= 0; i--) {// take i from the beginning and k - i from the end
            rearScore += cardPoints[n - (k - i)];
            frontScore -= cardPoints[i];
            int currentScore = rearScore + frontScore;
            maxScore = Math.max(maxScore, currentScore);
        }

        return maxScore;
    }
}
