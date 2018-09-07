class Solution {
    public int romanToInt(String s) {
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            char cur = s.charAt(i);
            if (cur == 'M') nums[i] = 1000;
            else if (cur == 'D') nums[i] = 500;
            else if (cur == 'C') nums[i] = 100;
            else if (cur == 'L') nums[i] = 50;
            else if (cur == 'X') nums[i] = 10;
            else if (cur == 'V') nums[i] = 5;
            else if (cur == 'I') nums[i] = 1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) sum -= nums[i]; //如果后面比前面的大说明前面是负的
            else sum += nums[i];
        }
        return sum += nums[nums.length - 1];
    }
}
/*或者直接用 res a1, a2 a2 > a1 那么就res-a1然后a1=a2

class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int a1=getValue(s.charAt(0));
        for(int i=1;i<s.length();i++){
            int a2=getValue(s.charAt(i));
            if(a1<a2){
                res = res-a1;
            }
            else
                res = res+a1;
            a1=a2;
        }
        res+=a1;
        return res;
        
    }
    public int getValue(char c){
        switch(c){
            case'M':
                return 1000;
            case'D':
                return 500;
            case'C':
                return 100;
            case'L':
                return 50;
            case'X':
                return 10;
            case'V':
                return 5;
            case'I':
                return 1;
        }
        return 0;
    }
} */
