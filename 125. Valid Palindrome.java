class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !Character.isLetterOrDigit(s.charAt(left))) left++; //这三行都加上left <= right防止“  ”这种多空格情况越界
            while (left <= right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if  (left <= right && Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }        
        return true;
    }
}
