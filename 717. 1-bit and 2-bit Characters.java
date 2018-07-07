class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if (bits.length < 2) return true;
        int i = 0;
        while (i < bits.length - 1) { //不用for 要不然每次还要++
            if (bits[i] == 1) i += 2; //1开头的只能两位， 0开头的只能1位，看最后是不是停在最后一位
            else i++;
        }
        return i == bits.length - 1;
    }
}
