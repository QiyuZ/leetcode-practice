class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills.length == 0) return true;
        if (bills[0] != 5) return false;
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) five++;
            else if (bill == 10) {
                ten++;
                five--;
            }
            else { //20
                if (ten > 0) { //有限给10元，因为五元可以组成10元，反之不可
                    ten--;
                    five--;
                } else five -= 3;
            }
            if (five < 0) return false;
        }
        return true;
    }
}
