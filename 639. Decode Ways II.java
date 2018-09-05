class Solution {
    public int numDecodings(String s) {
        /* initial conditions */
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;

        /* bottom up method */
        for(int i = 2; i <= s.length(); i++){
            char first = s.charAt(i-2);
            char second = s.charAt(i-1);

            // For dp[i-1]
            if(second == '*'){
                dp[i] += 9*dp[i-1];
            }else if(second > '0'){
                dp[i] += dp[i-1];
            }
            
            // For dp[i-2]
            if(first == '*'){
                if(second == '*'){
                    dp[i] += 15*dp[i-2];
                }else if(second <= '6'){
                    dp[i] += 2*dp[i-2];
                }else{
                    dp[i] += dp[i-2];
                }
            }else if(first == '1' || first == '2'){
                if(second == '*'){
                    if(first == '1'){
                       dp[i] += 9*dp[i-2]; 
                    }else{ // first == '2'
                       dp[i] += 6*dp[i-2]; 
                    }
                }else if( ((first-'0')*10 + (second-'0')) <= 26 ){
                    dp[i] += dp[i-2];    
                }
            }

            dp[i] %= 1000000007;
        }
        /* Return */
        return (int)dp[s.length()];
    }
}

// class Solution {
//     public int numDecodings(String s) {
//         int n = s.length();
//         double mod = Math.pow(10, 9) + 7;
//         int dp[] = new int[n + 1];
//         if (s.charAt(0) == '0') return 0;
//         dp[0] = 1; //初始化为1默认单个字符
//         dp[1] = s.charAt(0) == '*' ? 9 : 1; //初始化第一个
//         for (int i = 2; i <= n; i++) { //因为要看前两位所以从2开始
//             char one = s.charAt(i - 1), ten = s.charAt(i - 2); //定义个位和十位
//             if (one == '0') { //case 1 本位是0 ，那么如果ten不是1,2，*的话不能成立
//                 if (ten == '1' || ten == '2') dp[i] += dp[i - 2];
//                 else if (ten == '*') dp[i] += 2 * dp[i - 2]; //可1可2
//                 else return 0;
//             } else if (one >= '1' && one <= '9') { //case 2 0-9
//                 dp[i] += dp[i - 1]; //正常情况下都要先+前面的
//                 if (ten == '1' || (ten == '2' && one <= '6')) dp[i] += dp[i - 2]; //10+或26以下则可以形成新路径
//                 else if (ten == '*') dp[i] += (one <= '6') ? 2 * dp[i - 2] : dp[i - 2]; //*就取决于后面了，小于6可以15,25，大于6就只能2开头
//             } else if (one == '*') { //case 3 *
//                 dp[i] += 9 * dp[i - 1];
//                 if (ten == '1') dp[i] += 9 * dp[i - 2];
//                 else if (ten == '2') dp[i] += 6 * dp[i - 2];
//                 else if (ten == '*') dp[i] += 15 * dp[i - 2];
//             }
//             dp[i] %= mod;
//         }
//         return dp[n];
//     }


