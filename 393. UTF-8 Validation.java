class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) return false;
        int bitNum = 0; //后面还有几位
        for (int i = 0; i < data.length; i++) {
            if (data[i] >= 256) return false; //at most 8 digits. 9 digits is 256
            if ((data[i] & 128) == 0) bitNum = 0; //0XXXXXXX
            else if ((data[i] & 224) == 192) bitNum = 1; //要确定是110xxxxx ， 要拿11100000来&看是不是11000000，因为如果用11000000 来&， 111XXXXX也可以通过
            else if ((data[i] & 240) == 224) bitNum = 2;
            else if ((data[i] & 248) == 240) bitNum = 3;
            else return false;
            for (int j = 1; j <= bitNum; j++) { //因为可以多组组合比如[197, 130, 1]，所以要走完
                if (i + j >= data.length || (data[i + j] & 192) != 128) return false;
            }
            i += bitNum;
        }
        return true;
    }
}
