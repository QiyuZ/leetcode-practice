/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int i = 0, len;
        char[] tmp = new char[4];
        while (i < n && (len = read4(tmp)) > 0) { //当len=0说明到了尽头
            for (int j = 0; j < len && i < n; j++, i++) buf[i] = tmp[j];  //多次读，一直往buf里填充，i不重置
        }
        return i;
    }
}
