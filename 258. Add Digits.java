class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0; //潜在答案只有0到9 列举1,20即可找到规律
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}

class Solution {
    public int addDigits(int num) {
        while(num / 10 > 0){   
            int sum = 0; 
            while(num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
}
