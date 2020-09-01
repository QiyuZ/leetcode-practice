/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int index = 0;
        while (index < n) {
            int count = read4(temp); //题目意思是读取的数字都会放在这个temp里面，同理填充buf
            if (count == 0) break; //没有了也要停止
            for (int i = 0; i < count && index < n; i++) buf[index++] = temp[i]; //此处也要index < n防止读空
        }
        return index;
    }
}
