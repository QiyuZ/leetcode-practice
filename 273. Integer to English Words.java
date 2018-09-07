public class Solution {
    private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    //3111  /1000 3 thousand 111/100 1 hundred 11 belowTwenty[1] ->
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String pre = "";
        if (num < 0) {
            num = -num;
            pre = "Negative ";
        }
        return pre + helper(num); 
    }
    
    private String helper(int num) {
        String res = "";
        if (num < 10) res = belowTen[num];
        else if (num < 20) res = belowTwenty[num - 10];
        else if (num < 100) res = belowHundred[num / 10] + " " + helper(num % 10); //99 9, 9
        else if (num < 1000) res = belowTen[num / 100] + " Hundred " + helper(num % 100); //999
        else if (num < 1000000) res = helper(num / 1000) + " Thousand " + helper(num % 1000); //999,999
        else if (num < 1000000000) res = helper(num / 1000000) + " Million " + helper(num % 1000000); //999,999,999
        else res = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        return res.trim(); //will be space in the end
    }
}
