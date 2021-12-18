// class Solution {
//     public int atMostNGivenDigitSet(String[] digits, int n) {
//         if (n <= 0) return 0;
//         int count = 0;
//         String s = Integer.toString(n);
//         for (int i = 1; i <= s.length(); i++) count += countValidNum(digits, i, s);
//         return count;
//     }
    
//     private int countValidNum(String[] digits, int curLength, String max) {
//         if ("0".equals(max)) return 0; 
//         if (max.length() > curLength) return (int)Math.pow(digits.length, curLength); //like if max is 10000, and digits=[1,2,3] and curlength=2 then its 3^2
//         int count = 0;
//         for (String digit : digits) { //curLength >= cur.length()
//             char fchar = max.charAt(0);
//             if (Integer.parseInt(digit) < (fchar - '0')) count += countValidNum(digits, curLength - 1, max); //if max first char is lager than means all the followings will be valid
//             else if (Integer.parseInt(digit) == (fchar - '0')) { //if they are equal then hard to say, need to compare the followings
//                 if (max.length() > 1) count += countValidNum(digits, curLength - 1, max.substring(1));
//                 else count++;
//             }
//         }
//         return count;
//     }
// }

class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        char[] N = String.valueOf(n).toCharArray();
        int len = N.length;
        int res = 1, pres = 1, smaller = -1;
        
        for(int i = 1, m = 1; i <= len; i++, m *= digits.length) {
            pres = res;
            res = 0;
            int x = N[len-i] - '0';
            for(String d: digits) {
                if(Integer.valueOf(d) < x) res += m;
                else if(Integer.valueOf(d) == x) res += pres;
            }
            smaller += m;
        }
        
        return res + smaller;
    }
}
