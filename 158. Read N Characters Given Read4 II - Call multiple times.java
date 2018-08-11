/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private int count = 0, pointer = 0; //count为每次的长度，pointer为temp中的位置，这些是累计的所以是global
    private char[] temp = new char[4];
    public int read(char[] buf, int n) {
        int index = 0; //分开每次所以local
        while (index < n) {
            if (pointer == 0) count = read4(temp); //pointer=0说明上一段已经读完了，开始下一段
            if (count == 0) break; //整体读到了尽头
            while (pointer < count && index < n) buf[index++] = temp[pointer++]; 
            if (pointer == count) pointer = 0;//这一段走完了
        }
        return index;
    }
}
