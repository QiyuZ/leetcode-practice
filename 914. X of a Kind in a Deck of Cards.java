class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 1) return false;
        int[] count = new int[10000];
        for (int num : deck) count[num]++;
        int gcd = 0;
        for (int num : count) gcd = getGcd(gcd, num);
        if (gcd == 1) return false; //找集体最大公约数，不是1即可
        return true;
    }
    
    private int getGcd(int a, int b) {
        if (b == 0) return a; 
        return getGcd(b, a % b); //这个可以这么记顺序，默认b小，所以下次要把a变小放在b的位置然后b不变放在a处
        //或者 if (a == 0) return b; return getGcd(b % a, a);
    }
}
