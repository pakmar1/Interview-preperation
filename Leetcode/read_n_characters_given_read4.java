/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        
        int len = 0; 
        while (len < n) {
            char[] read4buf = new char[4];
            int read4Len = read4(read4buf);

            if (read4Len == 0) {
                break;
            }

            if (read4Len + len > n) {
                read4Len = n - len;
            }

            for (int i = 0; i < read4Len; i++) {
                buf[len++] = read4buf[i];
            }
        }
        return len;
    }
}
