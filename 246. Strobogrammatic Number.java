class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) return true;
        int l = 0, r = num.length() - 1;
        while (l <= r) {
            char left = num.charAt(l), right = num.charAt(r);
            if (left == '0') {
                if (right != '0') return false;
            } else if (left == '1') {
                if (right != '1') return false;
            } else if (left == '6') {
                if (right != '9') return false;
            } else if (left == '9') {
                if (right != '6') return false;
            } else if (left == '8') {
                if (right != '8') return false;
            } else return false;
            l++;
            r--;
        }
        return true;
    }
}
