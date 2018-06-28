class Solution {
    public void reverseWords(char[] str) {
        int n = str.length;
        reverse(str, 0, n - 1);
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        reverse(str, start, n - 1); //防止只有一个单词，此时start就在末尾
    }
    public void reverse(char[] nums, int start, int end) {
        while (start < end) {
            char temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
